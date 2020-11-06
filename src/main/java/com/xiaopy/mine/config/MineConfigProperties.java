package com.xiaopy.mine.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xiaopeiyu
 * @since 2020/11/5
 */
@Data
@ConfigurationProperties("mine.spring")
public class MineConfigProperties {
    private String ip;

    private int port;
}
