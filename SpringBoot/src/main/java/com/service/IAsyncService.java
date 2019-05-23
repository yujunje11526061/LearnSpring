package com.service;

import java.util.concurrent.Future;

public interface IAsyncService {

    public Future<Long> doTask1() throws InterruptedException;
    public Future<Long> doTask2() throws InterruptedException;
    public Future<Long> doTask3() throws InterruptedException;

}
