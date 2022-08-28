package com.wq.store.service;

import com.wq.store.pojo.Address;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * Description 收货地址业务逻辑层接口
 *
 * @author WangQian
 * @create 2022-07-17 17:50
 */
public interface AddressService {

    /**
     * @param uid
     * @param username  当前登录的用户，而不是收货人
     * @param address
     */
    void addNewAddress(@Param("uid") Integer uid,@Param("username") String username,Address address);

    List<Address> getByUid(Integer uid);

    //修改某个用户的收货地址为默认地址
    void setDefault(Integer aid,Integer uid, String username);

    //删除用户选中的收货地址数据
    void delete(Integer aid,Integer uid,String username);
}
