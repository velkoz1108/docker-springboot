package com.f5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Twin
 * @Team Atplan
 * @date : 2018/8/15 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    @Test
    public void contextLoads() {
        System.out.println("true = " + true);
    }
}
