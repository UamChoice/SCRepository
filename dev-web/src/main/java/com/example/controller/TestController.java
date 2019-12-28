package com.example.controller;

import com.example.config.XLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exp")
public class TestController {

    /**
     * http://localhost:8889/exp/xlExp
     * @throws XLException
     */
    @RequestMapping("/xlExp")
    public void xlExp() throws XLException {
//        throw new Exception("Sam 错误");
        XLException exception = new XLException("555", "错误的请求");
        throw exception;
    }

    /**
     * http://localhost:8889/exp/zeroExp
     */
    @RequestMapping("/zeroExp")
    public void zeroExp() {
        int a = 1/0;
    }
}
