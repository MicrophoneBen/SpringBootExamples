package com.ben.springbootzk.service;

import com.ben.springbootzk.config.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author zhangbingquan
 * @desc Zookeeper的业务逻辑，路径的增删改查，临时节点，永久节点，序列化节点等
 * @time 2019/4/16 17:02
 */
@Service
public class ZkService {
    @Autowired
    ZkClient zkClientBuilder;

    public void createPath() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zkClient = zkClientBuilder.zkClientBuilder();

        //创建一个Zookeeper节点，传入路径， 数据，节点类型,这里是持久序列化节点
        zkClient.create("/myGirls", "性感的女孩".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
    }
}
