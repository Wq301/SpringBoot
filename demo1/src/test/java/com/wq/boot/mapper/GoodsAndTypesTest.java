package com.wq.boot.mapper;

import com.wq.boot.pojo.Goods;
import com.wq.boot.pojo.Types;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-16 19:59
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsAndTypesTest {
    @Autowired
    GoodTypesMapper goodTypesMapper;
    @Test
    public void TypesAndGoods(){
        Types t = goodTypesMapper.getGoodsByTypeId("2");
        System.out.println(t);
    }
    
    @Autowired
    GoodsMapper goodsMapper;
    @Test
    public void selectAllTypesAndGoods(){
        List<Types> types = goodTypesMapper.selectAllTypesAndGoods();
        for (Types types1:types){
            System.out.println(types1);
        }
    }
}