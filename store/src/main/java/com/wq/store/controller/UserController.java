package com.wq.store.controller;

import com.wq.store.controller.ex.*;
import com.wq.store.pojo.User;
import com.wq.store.service.UserService;
import com.wq.store.service.ex.InsertException;
import com.wq.store.service.ex.UsernameDuplicatedException;
import com.wq.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-25 9:30
 */
@RestController //相当于： @Controller+@ResponseBody

@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/reg")
    //@ResponseBody  //此方法的响应结果以json格式进行数据的响应给到前端
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);


        /**
         * //创建响应结果对象
         *         JsonResult<Void> result=new JsonResult<>();
         * try {
         *             userService.reg(user);
         *             result.setState(200);
         *             result.setMessage("用户注册成功！");
         *         } catch (UsernameDuplicatedException e) {
         *             result.setState(4000);
         *             result.setMessage("用户名被占用");
         *         }catch (InsertException e){
         *             result.setState(5000);
         *             result.setMessage("注册时产生的未知异常");
         *         }
         *         return result;
         */
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        //向session对象中完成数据的绑定（session是全局的）
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());

        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        User data = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        //user对象有四部分的数据：username,phone,email,gender
        //uid数据需要再次封装到user对象中
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<>(OK);
    }

    //设置文件上传的最大值
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    //设置文件上传的类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping("/change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session,
                                           @RequestParam("file") MultipartFile file) {
        /**
         * MultipartFile接口是SpringMVc提供的一个接口，为我们包装了获取文件类型的
         * 数据（任何类型的file）SpringBoot整合了SpringMVC,只需要在处理请求的方法
         * 参数列表上声明一个参数类型为MultipartFile的参数，就会自动将传递给服务器
         * 的文件数据赋值给这个参数
         *
         * @RequestParam表示将请求中的参数注入请求处理方法的某个参数上
         */

        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }
        if (!AVATAR_TYPE.contains(file.getContentType())) {
            throw new FileTypeException("文件类型不支持");
        }
        //上传的文件---》/upload/xxx.png
        String parent = session.getServletContext().getRealPath("upload");
        System.out.println("parent = " + parent);
        //File对象指向这个路径，file是否存在
        File dir=new File(parent);
        if(!dir.exists()){
            dir.mkdirs();  //创建当前目录
        }
        //获取到这个文件的名称：UUID工具来生成一个新的字符串作为文件名
        //例如：avatar01.png
        String originalFilename=file.getOriginalFilename();
        System.out.println("originalFilename="+originalFilename);
        String[] str = originalFilename.split("\\.");
        String suffix=str[1];
        String filename = UUID.randomUUID().toString().toUpperCase()+"."+suffix;

        File dest=new File(dir,filename);  //在dir文件下创建dest空文件
        //将参数file的数据写入到这个空文件中
        try {
            file.transferTo(dest);
        }catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar="/upload/"+filename;
        userService.changeAvatar(uid,avatar,username);
        //返回用户的头像的路径给前端页面，将来用于头像的展示使用
        return new JsonResult<>(OK,avatar);
    }
}