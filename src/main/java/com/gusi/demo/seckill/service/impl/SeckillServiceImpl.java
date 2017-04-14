package com.gusi.demo.seckill.service.impl;

import com.gusi.demo.seckill.dao.KilledResultDao;
import com.gusi.demo.seckill.dao.SeckillDao;
import com.gusi.demo.seckill.dto.SeckillInfo;
import com.gusi.demo.seckill.pojo.KilledResult;
import com.gusi.demo.seckill.pojo.Seckill;
import com.gusi.demo.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by GUSI on 2017/4/14.
 */
public class SeckillServiceImpl implements SeckillService {
    public static Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private KilledResultDao killedResultDao;

    public List<Seckill> querySeckillList(int offet, int limit) {
        return null;
    }

    public Seckill querySeckillDetail(long seckillId) {
        return null;
    }

    public SeckillInfo querySeckillInfo(long seckillId) {
        return null;
    }

    public void doingSeckill(long seckillId, String md5) {

    }

    private String getSeckillMd5(String seckillId){

        return null;
    }
}
