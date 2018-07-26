package com.course.testng;

import org.testng.annotations.Test;

//异常测试举例
public class ExpectedException {
    /**
     * 什么时候用到异常测试？
     * 在我们期望结果为某个异常的时候
     * 比如：我们传入了某些不合法的参数，程序应该抛出了异常，
     * 我们来测试程序是否能抛出该异常
     * 也就是说我的预期结果就是这个异常
     */

    //这是一个测试时会产生异常的异常测试(测试失败)
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }
    //这是一个测试时会产生异常的异常测试(测试成功)
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        //下边的代码一定会抛出异常，后边的代码无法运行
        throw new RuntimeException();
    }

}
