package com.gusi.demo.seckill.service.impl;

import com.gusi.demo.seckill.dao.KilledResultDao;
import com.gusi.demo.seckill.dao.SeckillDao;
import com.gusi.demo.seckill.dto.KilledDoing;
import com.gusi.demo.seckill.dto.SeckillInfo;
import com.gusi.demo.seckill.emum.KilledStateEnum;
import com.gusi.demo.seckill.exception.ClosedException;
import com.gusi.demo.seckill.exception.RepeatException;
import com.gusi.demo.seckill.exception.SeckillException;
import com.gusi.demo.seckill.pojo.KilledResult;
import com.gusi.demo.seckill.pojo.Seckill;
import com.gusi.demo.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

/**
 * 秒杀服务类
 * Created by GUSI on 2017/4/14.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    public static Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private KilledResultDao killedResultDao;

    @Override
    public List<Seckill> querySeckillList(int offet, int limit) {
        List<Seckill> results = seckillDao.queryAll(offet, limit);
        return results;
    }

    @Override
    public Seckill querySeckillDetail(long seckillId) {
        Seckill result = seckillDao.queryById(seckillId);
        return result;
    }

    @Override
    public SeckillInfo querySeckillInfo(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        boolean opend = false;
        if (seckill != null && seckill.getStartTime().getTime() < System.currentTimeMillis() && seckill.getEndTime().getTime() > System.currentTimeMillis()) {
            //返回秒杀信息
            opend = true;
        }

        SeckillInfo seckillInfo = new SeckillInfo();
        seckillInfo.setSeckillId(seckillId);
        seckillInfo.setOpened(opend);
        if (opend) {
            seckillInfo.setMd5(getSeckillMd5(seckillId + ""));
        } else {
            seckillInfo.setNowTime(System.currentTimeMillis());
            seckillInfo.setStartTime(seckill.getStartTime().getTime());
            seckillInfo.setEndTime(seckill.getEndTime().getTime());
        }

        return seckillInfo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public KilledDoing doingSeckill(long seckillId, String md5, String userMobile) throws SeckillException, RepeatException, ClosedException {
        String md5req = getSeckillMd5(seckillId + "");
        if (md5req.equals(md5)) {
            Date nowDtae = new Date();
            Seckill seckill = seckillDao.queryById(seckillId);
            if (nowDtae.getTime() > seckill.getEndTime().getTime()) {
                throw new ClosedException(KilledStateEnum.KILLED_ENDED.getStateInfo());
            }

            //执行减库存操作
            int reduce = seckillDao.reduceNumber(seckillId, nowDtae);
            if (reduce <= 0) {
                throw new RepeatException(KilledStateEnum.KILLED_ENDED.getStateInfo());
            }

            //执行秒杀操作
            int killed = killedResultDao.insertKilled(seckillId, userMobile);
            if (killed <= 0) {
                throw new RepeatException(KilledStateEnum.KILLED_REPEAT.getStateInfo());
            } else {
                KilledResult killedResult = killedResultDao.queryByIdWithSeckill(seckillId, userMobile);
                return new KilledDoing(seckillId, KilledStateEnum.KILLED_SUC, killedResult);
            }

        } else {
            throw new SeckillException(KilledStateEnum.KILLED_ERROR.getStateInfo());
        }
    }


    private String getSeckillMd5(String seckillId) {
        String salt = "asdikdsa;lkjfpoi77jkj;aslkdjfi";
        byte[] md5Bytes = DigestUtils.md5Digest((salt + seckillId).getBytes(Charset.forName("UTF-8")));
        return new String(md5Bytes);
    }
}
