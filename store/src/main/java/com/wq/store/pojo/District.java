package com.wq.store.pojo;

import com.wq.store.entity.BaseEntity;

import java.util.Objects;

/**
 * Description  省市区的数据实体类
 *
 * @author WangQian
 * @create 2022-07-17 23:53
 */
public class District extends BaseEntity {
    private Integer id;
    private String parent;   //父区域的代号
    private String code;    //该城市的代号（依赖于父代号）
    private String name;   //代号所表示的城市名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(id, district.id) && Objects.equals(parent, district.parent) && Objects.equals(code, district.code) && Objects.equals(name, district.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parent, code, name);
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}