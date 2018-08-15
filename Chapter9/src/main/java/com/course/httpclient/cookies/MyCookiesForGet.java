package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //用例存储cookie信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        //通过ResourceBundle把配置文件中的地址拿出来
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        //HttpClient 无法获取cookies信息，需要用DefaultHttpClient
        //HttpClient client = new DefaultHttpClient();
        //获取cookies信息要用DefaultHttpClient
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies信息
        //CookieStore store = client.getCookieStore();
        //这里不能重写创建store变量，要保证此store和成员变量中的store一致
        store = client.getCookieStore();
        List<Cookie> cookiesList = store.getCookies();
        for(Cookie cookie:cookiesList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name+" ; value="+value);
        }
    }
    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies() throws IOException{
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("status code = "+ statusCode);
        if(statusCode ==200) {
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }else{
            System.out.println("出错啦");
        }
    }
}
