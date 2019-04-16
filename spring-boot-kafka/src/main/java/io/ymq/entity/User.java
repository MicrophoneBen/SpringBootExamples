package io.ymq.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhangbingquan
 * @description KafKa发送的消息类型
 * @date 2019/4/16 0:56
 */
@Data
public class User {
    private Long id;    //id

    private String name;

    private Integer age;

    private String msg; //消息

    private LocalDate sendTime;  //时间戳
}
