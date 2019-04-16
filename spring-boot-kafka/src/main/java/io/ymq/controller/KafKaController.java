package io.ymq.controller;

import io.ymq.kafka.MsgConsumer;
import io.ymq.kafka.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbingquan
 * @description Kafka消息发送Controller层
 * @date 2019/4/16 1:16
 */
@RestController
public class KafKaController {
    @Autowired
    MsgProducer msgProducer;

    @Autowired
    MsgConsumer msgConsumer;

    @GetMapping("/sent")
    public String setData(){
        return msgProducer.sendData();
    }

}
