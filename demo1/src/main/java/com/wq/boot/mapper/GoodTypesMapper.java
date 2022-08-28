package com.wq.boot.mapper;

import com.wq.boot.pojo.Goods;
import com.wq.boot.pojo.Types;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-16 19:48
 */
@Mapper
public interface GoodTypesMapper {
    Types getGoodsByTypeId(@Param("typeId") String typeId);

    //实现多对多
    List<Types> selectAllTypesAndGoods();
}

