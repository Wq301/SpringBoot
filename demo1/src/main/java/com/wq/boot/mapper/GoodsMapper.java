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
 * @create 2022-07-16 19:52
 */
@Mapper
public interface GoodsMapper {
    Goods getAllGoodsByTypeId(@Param("typeId") String typeId);

    List<Types> getGoodsOfTypes(@Param("id")Integer id);


}
