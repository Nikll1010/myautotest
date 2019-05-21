/**
 * @program: myautotest
 * @description: LoginTest
 * @author Nikll
 * @date 2019/5/15 21:37
 */
package com.nikll.controller;

import com.nikll.utils.HttpClientUtil;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Nikll

 * @date 2019/5/15 21:37

 */
public class LoginTest {
    public void LoginTest(){
        System.out.println("我是LoginTest");
    }
    @Test
    public void loginTrue() {
        Map map = new HashMap();
        map.put("start",10);
        map.put("end",20);
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8080)
                    .setPath("/getUserList")
                    .setParameter("start", "10")
                    .setParameter("end", "20")
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet);
        try {
//            HttpClientUtil.httpclient.execute(httpGet);
//            CloseableHttpClient httpclient = new HttpClients.createDefault();
            CloseableHttpClient httpclient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
            HttpEntity httpResponseEntity = httpResponse.getEntity();
            httpResponse.getEntity();
            String result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
            System.out.println("httpResponse    "+httpResponse);
            System.out.println("result    "+result);
            System.out.println("Entity    "+httpResponseEntity.getContent());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("jjjjj");
    }
}