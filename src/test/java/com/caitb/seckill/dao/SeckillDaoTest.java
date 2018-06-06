package com.caitb.seckill.dao;

import com.caitb.seckill.entity.Seckill;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cai_tb on 2018/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount: " + updateCount);
    }

    @Test
    public void testQueryById() throws Exception {
        Long seckillId = 1000L;
        Seckill seckill = seckillDao.queryById(seckillId);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

}