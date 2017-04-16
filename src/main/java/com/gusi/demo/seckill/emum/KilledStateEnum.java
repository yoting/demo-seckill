package com.gusi.demo.seckill.emum;

/**
 * Created by gusi on 2017/4/16.
 */
public enum KilledStateEnum {
    KILLED_SUC(1, "秒杀成功"),
    KILLED_REPEAT(-1, "重复秒杀"),
    KILLED_ENDED(-2, "秒杀结束"),
    KILLED_ERROR(-9, "系统异常");


    private int state;
    private String stateInfo;

    private KilledStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
