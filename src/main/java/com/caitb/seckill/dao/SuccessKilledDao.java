package com.caitb.seckill.dao;

import com.caitb.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by cai_tb on 2018/6/6.
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细,可过滤重复
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId")Long seckillId, @Param("userPhone")Long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")Long seckillId, @Param("userPhone")Long userPhone);
}
