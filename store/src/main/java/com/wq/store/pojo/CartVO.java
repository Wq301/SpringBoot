package com.wq.store.pojo;

import com.wq.store.entity.BaseEntity;

import java.io.Serializable;

/**
 * Description  购物车数据的Value Object类
 *
 * @author WangQian
 * @create 2022-07-19 23:25
 */
public class CartVO extends BaseEntity implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private String title;
    private Long realPrice;
    private String image;
}