package com.wq.store.service.impl;

import com.wq.store.mapper.DistrictMapper;
import com.wq.store.pojo.District;
import com.wq.store.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-18 0:18
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictMapper districtMapper;
    @Override
    public List<District> findByParent(String parent) {
        List<District> parents = districtMapper.findByParent(parent);
        //在进行网络数据传输时，为了尽量避免无效数据的传递，可以将无效数据设置为null
        //可以节省流量，也可以提升效率
        for (District d:parents){
            d.setId(null);
            d.setParent(null);
        }
        return parents;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}