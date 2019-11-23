package com.example.controller;

import com.example.dto.validate.People;
import com.example.tools.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/validate")
public class ValidateController {
    private static final Logger logger = LoggerFactory.getLogger(ValidateController.class);

    @Autowired
    private ValidateUtil validateUtil;

    @PostMapping("/object")
    public String validateObject(@RequestBody @Validated People people, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            String msg = validateUtil.getAllErrorMsg(bindingResult);
            logger.info("validate object errmsg:{}",msg);
            return msg;
        }
        return people.toString();
    }
}
