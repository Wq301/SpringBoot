package com.wq.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-16 19:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Types {
    private String typeId;
    private String name;
//    private List<Goods> goods;
    private List<Detail> details;
}