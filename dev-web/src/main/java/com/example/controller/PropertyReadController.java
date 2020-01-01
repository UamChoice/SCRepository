package com.example.controller;

import com.example.tools.PropertiesListenerConfig;
import com.example.tools.PropertiesReadTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**   
* @Description： 4种方式读取properties文件
* @author： XL_FUTURE   
* @date： 2019年6月19日 下午9:40:57 
*/
@RestController
@RequestMapping("/read_value")
@Api(tags="读取properties文件参数")
public class PropertyReadController {
	@Autowired
    private PropertiesReadTool propertiesReadTool;
	
	@Value("${com.demo.type}")
    private String type;

    @Value("${com.demo.title}")
    private String title;
    
    @Autowired
    private Environment env;
    
	/**
     * 第一种方式：使用`@ConfigurationProperties`注解将配置文件属性注入到配置对象类中
     */
    @RequestMapping("/config")
    @ApiOperation(value="用一个Pojo类set/get接收参数",notes="包括string/list/map")
    public Map<String, Object> configurationProperties() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", propertiesReadTool.getType3());
        map.put("title", propertiesReadTool.getTitle3());
        map.put("login", propertiesReadTool.getLogin());
        map.put("urls", propertiesReadTool.getUrls());
        return map;
    }
    
    /**
     * 第二种方式：使用`@Value("${propertyName}")`注解
     */
    @RequestMapping("/value")
    @ApiOperation(value="使用@Value注解接收参数",notes="")
    public Map<String, Object> value() throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);
        map.put("title", new String(title.getBytes("ISO-8859-1"), "UTF-8"));
        //文字可正常显示
        map.put("title_normal", title);
        return map;
    }
    
    /**
     * 第三种方式：使用`Environment`
     */
    @RequestMapping("/env")
    @ApiOperation(value="使用spring Environment接收参数",notes="env.getProperty")
    public Map<String, Object> env() throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", env.getProperty("com.demo.type2"));
        map.put("title", new String(env.getProperty("com.demo.title2").getBytes("ISO-8859-1"), "UTF-8"));
        //文字可正常显示
        map.put("title_normal", env.getProperty("com.demo.title2"));
        return map;
    }
    
    /**
     * 第四种方式：通过注册监听器(`Listeners`) + `PropertiesLoaderUtils`的方式
     *
     * Application中main方法添加
     * //SpringApplication application = new SpringApplication(WebApplication.class);
     * // 第四种读取properties方式：注册监听器
     * //application.addListeners(new PropertiesListener("read_pro.properties"));
     * //application.run(args);
     */
    @RequestMapping("/listener")
    @ApiOperation(value="使用监听器接收参数",notes="必须要ApplicationListener以及application.addListeners")
    public Map<String, Object> listener() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.putAll(PropertiesListenerConfig.getAllProperty());
        return map;
    }
}
