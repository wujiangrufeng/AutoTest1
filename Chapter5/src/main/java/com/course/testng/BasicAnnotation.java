package com.course.testng;

import org.testng.annotations.*;

//标签学习举例
public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是在学习test标签");
    }
    @Test
    public void testCase2(){
        System.out.println("这是在学习test2标签");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在方法运行前执行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在方法运行之后执行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类运行之前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是在类运行之后运行的");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("测试套件之前");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("测试套件之后");
    }


}
