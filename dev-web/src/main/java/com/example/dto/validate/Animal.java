package com.example.dto.validate;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class Animal {
    @NotNull(message = "姓名不能为空")
    private String name;

    protected void eat(){
        System.out.println("eat food");
    };
}
