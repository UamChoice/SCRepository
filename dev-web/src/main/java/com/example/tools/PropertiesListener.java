package com.example.tools;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**   
* @Description： 配置文件监听器，用来加载自定义配置文件
* @author： XL_FUTURE   
* @date： 2019年6月19日 下午9:59:33 
*/
public class PropertiesListener implements ApplicationListener<ApplicationStartedEvent> {

    private String propertyFileName;

    public PropertiesListener(String propertyFileName) {
        this.propertyFileName = propertyFileName;
    }

	@Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        PropertiesListenerConfig.loadAllProperties(propertyFileName);
    }
}
