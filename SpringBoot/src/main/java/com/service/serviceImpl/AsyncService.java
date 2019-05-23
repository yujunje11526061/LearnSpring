package com.service.serviceImpl;

import com.service.IAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

@Service
public class AsyncService implements IAsyncService {

    private Random random = new Random();

    @Async // 加了这个注解就会单独开启一个子线程来异步执行任务, 另外还需在启动类中开启@EnableAsync
    @Override
    public Future<Long> doTask1() throws InterruptedException {
        System.out.println("任务一开始执行");
        System.out.println(Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("任务一结束执行");
        return new AsyncResult<>(end-start);
    }

    @Async
    @Override
    public Future<Long> doTask2() throws InterruptedException {
        System.out.println("任务二开始执行");
        System.out.println(Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("任务二结束执行");
        return new AsyncResult<>(end-start);
    }

    @Async
    @Override
    public Future<Long> doTask3() throws InterruptedException {
        System.out.println("任务三开始执行");
        System.out.println(Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("任务三结束执行");
        return new AsyncResult<>(end-start);
    }
}
