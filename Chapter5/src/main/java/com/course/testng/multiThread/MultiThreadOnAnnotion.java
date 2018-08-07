package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {

//invocationCount为线程数也就是线程共执行多少次，threadPoolSize为线程池数也就是共有几个线程
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread ID:%s%n",Thread.currentThread().getId());
    }
}
