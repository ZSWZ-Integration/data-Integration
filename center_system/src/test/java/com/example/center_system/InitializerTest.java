package com.example.center_system;

import com.example.center_system.initializer.StatisticCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitializerTest {

    @Test
    public void test(){
        System.out.println(StatisticCache.courseCache.getStatisticCourseList().get(0).getCname());
    }
}
