package com.wq.store.mapper;

import com.wq.store.pojo.Address;
import com.wq.store.pojo.District;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Description  收货地址持久层的接口
 *
 * @author WangQian
 * @create 2022-07-17 17:10
 */
public interface AddressMapper {
    /**
     * 插入用户的收货地址数据
     * @param address
     * @return  受影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的id统计收货地址的数量，最多20条
     * @param uid
     * @return
     */
    Integer countByUid(@Param("uid") Integer uid);

    //根据用户id查询用户收货地址数据
    List<Address> findByUid(Integer uid);

    //根据aid查询收货地址是否存在
    Address findByAid(Integer aid);

    //根据用户的uid值来修改用户的收货地址为非默认
    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(
                               @Param("aid") Integer aid,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);

    //根据收货地址的id删除收货地址的数据
    Integer deleteByAid(Integer aid);

    //根据用户uid查询当前用户最后一次修改的收货地址的数据
    Address findLastModified(Integer uid);
}
