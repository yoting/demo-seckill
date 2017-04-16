package com.gusi.demo.seckill.pojo;

import java.util.Date;

/**
 * 秒杀结果对象
 * Created by GUSI on 2017/4/14.
 */
public class KilledResult {
    private Long seckillId;
    private String userMobile;
    private int state;
    private Date createTime;

    private Seckill seckill;

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "KilledResult{" +
                "seckillId=" + seckillId +
                ", userMobile='" + userMobile + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
