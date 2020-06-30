package com.example.a_system.dao;

import com.example.a_system.dao.Repository.StatisticRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticDaoTest {
    @Autowired
    StatisticRepository statisticRepository;

    @Test
    public void getAllStudentStatisticTest(){
        statisticRepository.getAllStudentStatistic();
    }
}
