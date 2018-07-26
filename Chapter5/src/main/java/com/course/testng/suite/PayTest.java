package com.course.testng.suite;

import org.testng.annotations.Test;
//suite和Test标签学习举例
public class PayTest {

    @Test
    public void paySuccess(){
        System.out.println("支付宝支付成功");
    }
}
