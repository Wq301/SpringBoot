package com.wq.store.service;

import com.wq.store.pojo.District;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-18 0:15
 */
public interface DistrictService {

    //根据父代号来查询区域信息（省市区）
    List<District> findByParent(String parent);

    String getNameByCode(String code);
}
