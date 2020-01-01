package com.lhy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *  <groupId>org.springframework.boot</groupId>
 *  <artifactId>spring-boot-starter-actuator</artifactId>
 */
@RestController
@RefreshScope
@RequestMapping("/property")
public class PropertyController {

    @Value("${com.demo.type}")
    private String type;

    @Value("${com.demo.title}")
    private String title;

    @RequestMapping("/value")
    public Map<String, Object> value() throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);
        //文字可正常显示
        map.put("title", title);
        return map;
    }
}
