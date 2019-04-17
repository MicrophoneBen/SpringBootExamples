package com.ben.springbootzk.service;

import com.ben.springbootzk.Dto.ZkConfigDto;
import com.ben.springbootzk.config.ZkClient;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhangbingquan
 * @desc Zookeeper的业务逻辑，路径的增删改查，临时节点，永久节点，序列化节点等
 * @time 2019/4/16 17:02
 */
@Service
public class ZkService {
    @Autowired
    ZkConfigDto zkConfigDto;
    @Autowired
    ZkClient zkClientBuilder;
    //传入一个节点的状态对象,在每次有数据更新获取时，这个值会被更新
    private Stat stat = new Stat();
    private static String path = "/myGirls";
    private static CountDownLatch connectedSe = new CountDownLatch(1);
    private ZooKeeper zk = null;

    public void createPath() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zkClient = zkClientBuilder.zkClientBuilder();

        //创建一个Zookeeper节点，传入路径， 数据，节点类型,这里是持久序列化节点
        zkClient.create(path, "性感的女孩".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zkClient.close();
    }

    public String getNodeData() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = zkClientBuilder.zkClientBuilder();
        //获取节点数据内容
        String result = new String(zk.getData(path, true, stat));
        System.out.println(stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());
        System.out.println("更新数据");
        zk.setData(path, "MyGirlFriends".getBytes(), -1);
        return result;
    }


    public String getUpdate() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = zkClientBuilder.zkClientBuilder();
        //获取节点数据内容
        String result = new String(zk.getData(path, true, stat));
        System.out.println(stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());
        System.out.println("更新数据");
        zk.setData(path, "一位性感女孩".getBytes(), -1);
        return result;
    }
}