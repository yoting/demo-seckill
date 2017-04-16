package com.gusi.demo.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by gusi on 2017/4/16.
 */
public class ClosedException extends  SeckillException{

    public ClosedException() {
    }

    public ClosedException(String message) {
        super(message);
    }
}
