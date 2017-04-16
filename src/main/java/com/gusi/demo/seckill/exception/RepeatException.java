package com.gusi.demo.seckill.exception;

import org.springframework.test.annotation.Repeat;

/**
 * 重复秒杀异常
 * Created by gusi on 2017/4/16.
 */
public class RepeatException extends SeckillException {
    public RepeatException() {
    }

    public RepeatException(String message) {
        super(message);
    }
}
