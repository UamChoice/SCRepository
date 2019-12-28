package com.example.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
@Slf4j
public class ValidateUtil {

    public String getAllErrorMsg(BindingResult bindingResult){
        StringBuilder errorMsg = new StringBuilder();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        allErrors.forEach(error -> {
            if (errorMsg.indexOf(error.getDefaultMessage()) <= 0){
                errorMsg.append(error.getDefaultMessage() + ";");
            }
        });
        //log.info("错误信息：{}",errorMsg.toString());
        return errorMsg.toString();
    }
}
