package com.wq.store.service;

import com.wq.store.pojo.CartVO;

import java.util.List;

/**
 * Description 处理商品数据的业务层接口
 *
 * @author WangQian
 * @create 2022-07-19 22:48
 */
public interface CartService {

    /*** 将商品添加到购物车
     * * @param uid 当前登录用户的id
     * * @param pid 商品的id
     * * @param amount 增加的数量
     * * @param username 当前登录的用户名
     * */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /*** 查询某用户的购物车数据
     * * @param uid 用户id
     * * @return 该用户的购物车数据的列表
     * */
    List<CartVO> getVOByUid(Integer uid);
}
