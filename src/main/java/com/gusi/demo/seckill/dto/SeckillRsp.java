package com.gusi.demo.seckill.dto;

/**
 * Created by GUSI on 2017/4/18.
 */
public class SeckillRsp<T> {
    boolean state;
    T data;
    String error;

    public SeckillRsp(T data) {
        this.state = true;
        this.data = data;
    }

    public SeckillRsp(String error) {
        this.state = false;
        this.error = error;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
