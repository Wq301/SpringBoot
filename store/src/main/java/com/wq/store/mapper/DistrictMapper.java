package com.wq.store.mapper;

import com.wq.store.pojo.District;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-17 23:59
 */
public interface DistrictMapper {

    //根据父代号查询区域信息
    List<District> findByParent(String parent);
    String findNameByCode(String code);
}
