package com.wq.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-22 21:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {

    private Integer id;
    private Integer gId;
    private String tId;
    private Goods goods;
}