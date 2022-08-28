package com.wq.store.service;

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
 * @create 2022-07-18 0:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {

    @Autowired
    DistrictService districtService;
    @Test
    public void getByParent(){
        //86表示中国，所有省的父代号都是86
        List<District> list = districtService.findByParent("86");
        for (District d:list){
            System.out.println(d);
        }
    }
}