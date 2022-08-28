package com.wq.store.mapper;

import com.wq.store.pojo.Cart;
import com.wq.store.pojo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-19 22:30
 */
public interface CartMapper {
    // 插入购物车数据
    Integer insert(Cart cart);

    // 修改购物车数据中商品的数量
     Integer updateNumByCid(
             @Param("cid") Integer cid,
             @Param("num") Integer num,
             @Param("modifiedUser") String modifiedUser,
             @Param("modifiedTime") Date modifiedTime);

     // 根据用户id和商品id查询购物车中的数据
     Cart findByUidAndPid(
             @Param("uid") Integer uid,
             @Param("pid") Integer pid);

    /*** 查询某用户的购物车数据
     * * @param uid 用户id
     * * @return 该用户的购物车数据的列表
     * */
    List<CartVO> findVOByUid(Integer uid);
}
