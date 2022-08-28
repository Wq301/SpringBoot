package com.wq.store.controller;

import com.wq.store.controller.ex.*;
import com.wq.store.service.ex.*;
import com.wq.store.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * Description  控制层的基类
 *
 * @author WangQian
 * @create 2022-06-25 9:47
 */
public class BaseController {

    //操作成功的状态码
    public static final int OK=200;

    //用于统一处理抛出的异常
    @ExceptionHandler({ServiceException.class,FileUploadException.class})

    //当项目中产生了异常，被统一拦截到此方法中，这个方法在此时充当的是请求处理方法，返回值直接给到前端
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result=new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已经被占用的异常");
        }else if (e instanceof UsernameNoFoundException){
            result.setState(4001);
            result.setMessage("用户数据不存在的异常");
        }else if(e instanceof PasswordNoMatchException){
            result.setState(4002);
            result.setMessage("用户名的密码错误的异常");
        }else if(e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage("用户收货地址超出限制的异常");
        }else if (e instanceof AddressNotFoundException){
            result.setState(4004);
            result.setMessage("用户收货地址数据不存在的异常");
        }else if (e instanceof AccessDeniedException){
            result.setState(4005);
            result.setMessage("收货地址数据非法访问的异常");
        }else if (e instanceof ProductNotFoundException){
            result.setState(4006);
            result.setMessage("商品数据不存在的异常");
        }else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生的未知的异常");
        }else if (e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新数据时产生的未知的异常");
        }else if (e instanceof DeleteException){
            result.setState(5002);
            result.setMessage("删除数据时产生的未知的异常");
        }else if (e instanceof FileEmptyException){
            result.setState(6000);
            result.setMessage("文件上传为空时产生的未知的异常");
        }else if (e instanceof FileSizeException){
            result.setState(6001);
            result.setMessage("文件上传时文件大小时产生的未知的异常");
        }else if (e instanceof FileTypeException){
            result.setState(6002);
            result.setMessage("文件上传时类型产生的未知的异常");
        }else if (e instanceof FileStateException){
            result.setState(6003);
            result.setMessage("文件上传时文件状态产生的未知的异常");
        }else if (e instanceof FileUploadIOException){
            result.setState(6004);
            result.setMessage("文件上传时读取产生的未知的异常");
        }
        return result;
    }

    //获取session对象中的uid和username(当前登录的用户的uid、username)
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}