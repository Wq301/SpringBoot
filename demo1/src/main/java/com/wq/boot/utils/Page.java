package com.wq.boot.utils;

import com.wq.boot.service.ex.IndexOutBoundsException;
import com.wq.boot.service.ex.NullPointException;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-19 15:26
 */
public class Page {
    /**
     * 实现分页功能
     *
     * @param list     列表
     * @param pageSize 每页条数
     * @param pageNo   当前页码
     * @return
     */
    public static List page(List list, Integer pageSize, Integer pageNo) {
        Integer value = list.size() % pageSize;
        //总页码数
        Integer pageCount;
        if (value == 0) {
            pageCount = list.size() / pageSize;
        } else {
            pageCount = (list.size() / pageSize) + 1;
        }
        System.out.println(pageCount);

        //获取结果集
        List result = new ArrayList();
        int num=(pageNo - 1) * pageSize;
        if (pageNo > pageCount) {
            return null;
        } else if (pageNo == pageCount && pageSize > value) {
//            for(int i=0;i<value;i++){
//                result.add(list.get(num++));
//            }
            result.addAll(list.subList(num,num+value));
            return result;
        }
//        for(int j=0;j<pageSize;j++){
//            result.add(list.get(num++));
//        }
        result.addAll(list.subList(num,num+pageSize));
        return result;
    }

    public static List page1(List list, Integer pageSize, Integer pageNo) {

        if (list == null) {
            throw new NullPointException("查询集合中的数据为空");
        }
        //总页码数
        Integer value = list.size() % pageSize;
        Integer pageCount;
        if (value == 0) {
            pageCount = list.size() / pageSize;
        } else {
            pageCount = (list.size() / pageSize) + 1;
        }
        System.out.println(pageCount);
        //剩下的条数
        Integer count = list.size() - pageNo;
        if (pageSize > count || pageNo > pageCount) {
            throw new IndexOutBoundsException("查询范围越界的异常");
        }
        //获取结果
        List result = new ArrayList();
        for (int i = 0; i < pageSize; i++) {
            result.add(list.get(pageNo++));
        }
        return result;
    }
}