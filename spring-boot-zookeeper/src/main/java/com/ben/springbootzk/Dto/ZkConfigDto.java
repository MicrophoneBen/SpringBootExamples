package com.ben.springbootzk.Dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangbingquan
 * @desc Zookeeper客户端的属性加载类
 * @time 2019/4/16 16:38
 */
@ConfigurationProperties(prefix = "zookeeper")
@Component
@Data
public class ZkConfigDto {
    private String nodesPort;
    private Integer conecTimeOut;

}
