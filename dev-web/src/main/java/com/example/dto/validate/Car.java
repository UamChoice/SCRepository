package com.example.dto.validate;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Car {

    @NotBlank(message = "车牌号不能为空")
    private String carCode;
}
