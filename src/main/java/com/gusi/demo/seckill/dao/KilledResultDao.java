package com.gusi.demo.seckill.dao;

import com.gusi.demo.seckill.pojo.KilledResult;
import org.apache.ibatis.annotations.Param;

/**
 * Created by GUSI on 2017/4/14.
 */
public interface KilledResultDao {

    /**
     * 执行秒杀
     *
     * @param seckillId
     * @param userMobile
     * @return 插入的行数
     */
    int insertKilled(@Param("seckillId") long seckillId, @Param("userMobile") String userMobile);

    /**
     * 查询秒杀结果
     *
     * @param seckillId
     * @return 返回包含seckill对象
     */
    KilledResult queryByIdWithSeckill(@Param("seckillId") long seckillId);


}
