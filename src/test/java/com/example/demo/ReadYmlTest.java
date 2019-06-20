package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

/**   
* @Description： TODO
* @author： XL_FUTURE   
* @date： 2019年6月19日 下午10:32:51 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadYmlTest {
	
	private static final Logger ymlTestLogger = LoggerFactory.getLogger(ReadYmlTest.class);
	
	@Value("${myweb.port}")
    private String port;

    @Value("${spring.banner.location}")
    //application-dev.yml
    private String location;
    
    @Value("${spring.profiles.active}")
    private String active;
    
    @Value("${com.demo.type2}")
    private String oth_type;
    
    /**
     *  读取自定义yml打印：8889
     *  读取application-dev.yml打印：mybanner.txt
		读取application.properties打印：dev
		读取read_pro.properties打印：Springboot-Environment
     */
    @Test
    public void print() {
    	ymlTestLogger.info("读取自定义yml打印："+port);
    	ymlTestLogger.info("读取application-dev.yml打印："+location);
    	ymlTestLogger.info("读取application.properties打印："+active);
    	ymlTestLogger.info("读取read_pro.properties打印："+oth_type);
    }
}
