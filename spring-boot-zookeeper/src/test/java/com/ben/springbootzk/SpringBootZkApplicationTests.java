package com.ben.springbootzk;

import com.ben.springbootzk.Dto.ZkConfigDto;
import com.ben.springbootzk.config.ZkClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootZkApplicationTests {

    @Autowired
    ZkConfigDto zkConfigDto;
    @Autowired
    ZkClient zkClient;

    @Test
    public void contextLoads() {
        System.out.println(zkConfigDto.toString());
    }

    @Test
    public void testZkClient() throws IOException {
        zkClient.zkClientBuilder();
    }

}
