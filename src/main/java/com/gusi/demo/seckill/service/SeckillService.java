package com.gusi.demo.seckill.service;

import com.gusi.demo.seckill.dto.SeckillInfo;
import com.gusi.demo.seckill.pojo.Seckill;

import java.util.List;

/**
 * Created by GUSI on 2017/4/14.
 */
public interface SeckillService {
    List<Seckill> querySeckillList(int offet,int limit);
    Seckill querySeckillDetail(long seckillId);
    SeckillInfo querySeckillInfo(long seckillId);
    void doingSeckill(long seckillId,String md5);
}
