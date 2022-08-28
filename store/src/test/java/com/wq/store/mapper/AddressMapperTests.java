package com.wq.store.mapper;

import com.wq.store.pojo.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-17 17:35
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {
    @Autowired
    AddressMapper addressMapper;
    @Test
    public void insert(){
        Address address=new Address();
        address.setUid(8);
        address.setPhone("14785234587");
        address.setName("小baby");
        addressMapper.insert(address);
    }
    @Test
    public void countByUid(){
        Integer row = addressMapper.countByUid(8);
        System.out.println("收货地址条数" + row);
    }

    @Test
    public void findByUid(){
        List<Address> list = addressMapper.findByUid(8);
        for (Address address:list){
            System.out.println(address);
        }
    }

    @Test
    public void findByAid(){
        Address address = addressMapper.findByAid(7);
        System.out.println(address);
    }

    @Test
    public void updateNonDefault(){
        Integer rows = addressMapper.updateNonDefault(12);
        System.out.println("受影响行数为："+rows+"行");
    }

    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(7,"小明",new Date());
    }

    @Test
    public void deleteByAid(){
        Integer rows = addressMapper.deleteByAid(4);
        System.out.println("受影响行数为："+rows+"行");
    }

    @Test
    public void findLastModified(){
        Address lastModified = addressMapper.findLastModified(12);
        System.out.println(lastModified);
    }
}