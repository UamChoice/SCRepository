package com.example.dto.validate;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * // NotNull   [所有类型]不能没有，参数不能是Null
 * // NotBlank  [string]要有实际长度
 * // NotEmpty  【String List Map 数组】不能为null且长度>0
 */
@Data
public class People extends Animal{
    @Max(value = 99,message = "max age is 99")
    @Min(0)
    private int age;

    @Email
    @NotNull(message = "邮箱不能为空")
    private String email;

    @Valid      //嵌套检验。如果没有，则不会校验car中的字段
    @NotNull(message = "车辆信息不能为空")    //不能为空
    private Car car;

    @NotBlank(message = "爱好不能为空")
    private String hobby;
}
