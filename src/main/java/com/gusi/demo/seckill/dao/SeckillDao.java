package com.gusi.demo.seckill.dao;

import com.gusi.demo.seckill.pojo.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by GUSI on 2017/4/14.
 */
public interface SeckillDao {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return
     */
    int redurceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);


    /**
     * 查询秒杀商品
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(@Param("seckillId") long seckillId);

    /**
     * 查询所有秒杀商品
     *
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offet") int offet, @Param("limit") int limit);


}
