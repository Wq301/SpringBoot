package com.wq.store.utils;

import java.io.Serializable;

/**
 * Description   所有响应都使用Json格式进行数据响应
 *
 * @author WangQian
 * @create 2022-06-25 9:24
 */
public class JsonResult<E> implements Serializable {
    private Integer state;          //状态码
    private String message;         //描述信息
    private E data;                 //数据

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}