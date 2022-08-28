package com.wq.store.entity;


import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Description  实体类的基类
 *
 * @author WangQian
 * @create 2022-06-24 14:35
 */
public class BaseEntity implements Serializable {
    private String createdUser;      //日志-创建人
    private Date createdTime;        //日志-创建时间
    private String modifiedUser;     //日志-最后修改执行人
    private Date modifiedTime;       //日志-最后修改时间




    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }



    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

}