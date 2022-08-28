package com.wq.store.mapper;

import com.wq.store.pojo.District;
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
 * @create 2022-07-18 0:06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTests {
    @Autowired
    DistrictMapper districtMapper;
    @Test
    public void findByParent(){
        List<District> parents = districtMapper.findByParent("110100");
        for (District parent:parents){
            System.out.println(parent);
        }
    }

    @Test
    public void findNameByCode(){
        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);
    }
}