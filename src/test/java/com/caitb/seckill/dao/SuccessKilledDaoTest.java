package com.caitb.seckill.dao;

import com.caitb.seckill.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by cai_tb on 2018/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        Long seckillId = 1000L;
        Long phone = 13669660493L;
        int insertCount = successKilledDao.insertSuccessKilled(seckillId, phone);
        System.out.println("insertCount: " + insertCount);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        Long seckillId = 1000L;
        Long phone = 13669660493L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}