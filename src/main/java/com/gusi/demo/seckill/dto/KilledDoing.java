package com.gusi.demo.seckill.dto;

import com.gusi.demo.seckill.emum.KilledStateEnum;
import com.gusi.demo.seckill.pojo.KilledResult;

/**
 * 执行秒杀结果返回对象
 * Created by gusi on 2017/4/16.
 */
public class KilledDoing {
    long seckillId;
    int killedState;
    String killedStateInfo;
    KilledResult killedResult;

    public KilledDoing(long seckillId, KilledStateEnum killedState) {
        this.seckillId = seckillId;
        this.killedState = killedState.getState();
        this.killedStateInfo = killedState.getStateInfo();
    }

    public KilledDoing(long seckillId, KilledStateEnum killedState, KilledResult killedResult) {
        this.seckillId = seckillId;
        this.killedState = killedState.getState();
        this.killedStateInfo = killedState.getStateInfo();
        this.killedResult = killedResult;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getKilledState() {
        return killedState;
    }

    public void setKilledState(int killedState) {
        this.killedState = killedState;
    }

    public String getKilledStateInfo() {
        return killedStateInfo;
    }

    public void setKilledStateInfo(String killedStateInfo) {
        this.killedStateInfo = killedStateInfo;
    }

    public KilledResult getKilledResult() {
        return killedResult;
    }

    public void setKilledResult(KilledResult killedResult) {
        this.killedResult = killedResult;
    }
}
