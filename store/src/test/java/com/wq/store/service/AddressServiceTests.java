package com.wq.store.service;

import com.wq.store.pojo.Address;
import com.wq.store.service.impl.AddressServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-17 23:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {
    @Autowired
    AddressService addressService;
    @Test
    public void addNewAddress(){
        Address address=new Address();
        address.setPhone("13246464646");
        address.setName("张三");
        addressService.addNewAddress(8,"管理员",address);
    }

    @Test
    public void setDefault(){
        addressService.setDefault(5,12,"管理员");
    }
}