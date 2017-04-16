package com.gusi.demo.seckill.service;

import com.gusi.demo.seckill.dto.KilledDoing;
import com.gusi.demo.seckill.dto.SeckillInfo;
import com.gusi.demo.seckill.exception.ClosedException;
import com.gusi.demo.seckill.exception.RepeatException;
import com.gusi.demo.seckill.exception.SeckillException;
import com.gusi.demo.seckill.pojo.Seckill;

import java.util.List;

/**
 * Created by GUSI on 2017/4/14.
 */
public interface SeckillService {
    List<Seckill> querySeckillList(int offet, int limit);

    Seckill querySeckillDetail(long seckillId);

    /**
     * 查询秒杀信息
     *
     * @param seckillId
     * @return 正常时间内返回商品信息, 否则返回开启秒杀时间
     */
    SeckillInfo querySeckillInfo(long seckillId);

    /**
     * 执行秒杀
     *
     * @param seckillId
     * @param md5
     * @param userMobile
     * @return
     * @throws SeckillException
     * @throws RepeatException
     * @throws ClosedException
     */
    KilledDoing doingSeckill(long seckillId, String md5, String userMobile) throws SeckillException, RepeatException, ClosedException;
}
