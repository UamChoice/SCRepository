package com.example.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

/**   
* @Description： 读取properties文件的4种方式
* @author： XL_FUTURE   
* @date： 2019年6月18日 下午11:44:05 
*/
@Component
@ConfigurationProperties(prefix="com.demo")
@PropertySource(value="classpath:read_pro.properties")  //默认是application.properties
public class PropertiesReadTool {
	//加载YML格式自定义配置文件
	@Bean
	public PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		//yaml.setResources(new FileSystemResource("read-yml.yml"));//File引入
		yaml.setResources(new ClassPathResource("read-yml.yml"));//class引入
		configurer.setProperties(yaml.getObject());
		return configurer;
	}
		
	public String type3;
    public String title3;
    public Map<String, String> login = new HashMap<String, String>();
    public List<String> urls = new ArrayList<>();
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getTitle3() {
		return title3;
	}
	public void setTitle3(String title3) {
		this.title3 = title3;
	}
	public Map<String, String> getLogin() {
		return login;
	}
	public void setLogin(Map<String, String> login) {
		this.login = login;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
}

	
