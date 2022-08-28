package com.wq.boot3.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-23 19:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserLogin {
    private String username;
    private String password;

}