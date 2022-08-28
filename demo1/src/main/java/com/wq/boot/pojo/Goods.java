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
 * @create 2022-07-16 19:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private String gname;
    private Integer price;
//    private String typeId;
//    private List<Types> types;
}