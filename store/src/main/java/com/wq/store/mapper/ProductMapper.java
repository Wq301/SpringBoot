package com.wq.store.mapper;

import com.wq.store.pojo.Product;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-19 21:42
 */
public interface ProductMapper {
    /**
     *  查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /*** 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    Product findById(Integer id);

}
