package com.xiaopy.mine.config;

import com.xiaopy.mine.domain.MyObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaopeiyu
 * @since 2020/11/5
 */
@Configuration
@EnableConfigurationProperties(MineConfigProperties.class)
public class MineAutoConfig {


    @Bean
    @ConditionalOnMissingBean(MyObject.class)
    public MyObject myObject(MineConfigProperties properties){
        System.out.println(">>>>> init bean >>>>>");
        MyObject myObject = new MyObject();
        myObject.setIp(properties.getIp());
        myObject.setPort(properties.getPort());
        return myObject;
    }

}
