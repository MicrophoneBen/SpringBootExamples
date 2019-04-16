package com.ben.springbootzk.config;

import com.ben.springbootzk.Dto.ZkConfigDto;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zhangbingquan
 * @desc 创建一个Zookeeper客户端
 * @time 2019/4/16 16:36
 */
@Component
public class ZkClient {
    @Autowired
    ZkConfigDto zkConfigDto;

    public ZooKeeper zkClientBuilder() throws IOException {
        ZooKeeper zkClient = new ZooKeeper(zkConfigDto.getNodesPort(), zkConfigDto.getConecTimeOut(), event -> {
            System.out.println(event.getState());
            System.out.println(event.getType());
            System.out.println(event.getPath());
        });

        return zkClient;
    }
}
