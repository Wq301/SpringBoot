package com.wq.store.controller;

import com.wq.store.pojo.CartVO;
import com.wq.store.service.CartService;
import com.wq.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-19 22:58
 */
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/add_to_cart")
    public JsonResult<Void> addToCart(
            Integer pid,
            Integer amount,
            HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行添加到购物车
        cartService.addToCart(uid, pid, amount, username);
        // 返回成功
        return new JsonResult<Void>(OK);
    }

    @GetMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        // 从Session中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByUid(uid);
        // 返回成功与数据
        return new JsonResult<List<CartVO>>(OK, data);
    }
}