package com.ben.springbootzk.controller;

import com.ben.springbootzk.service.ZkService;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhangbingquan
 * @desc Zookeeper视图层，这里创建一个持久序列化节点。
 * @time 2019/4/16 17:11
 */
@RestController
public class ZkController {
    @Autowired
    ZkService zkService;

    @GetMapping("/create")
    public String createZkNode() throws InterruptedException, IOException, KeeperException {
        zkService.createPath();
        return "success";
    }

}
