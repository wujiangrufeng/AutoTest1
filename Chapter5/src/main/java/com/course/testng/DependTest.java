package com.course.testng;

import org.testng.annotations.Test;

//依赖测试举例
public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 run");
        //下边的代码一定会抛出异常，后边的代码无法运行
        //throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
