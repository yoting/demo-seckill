package com.gusi.demo.seckill.exception;

/**
 * 秒杀异常
 * Created by gusi on 2017/4/16.
 */
public class SeckillException extends RuntimeException {
    public SeckillException() {
    }

    public SeckillException(String message) {
        super(message);
    }
}
