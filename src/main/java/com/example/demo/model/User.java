package com.example.demo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(value="id")
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String sex;

}