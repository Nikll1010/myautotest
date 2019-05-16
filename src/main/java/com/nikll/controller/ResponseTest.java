/**
 * @program: myautotest
 * @description: HttpClientUtil
 * @author Nikll
 * @date 2019/5/15 22:33
 */
package com.nikll.controller;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Nikll
 * @date 2019/5/15 22:33
 */
public class ResponseTest {

    CloseableHttpClient httpclient = HttpClients.createDefault();

    /**
     * 响应处理test
     */
    @Test
    public void myGet() {
        HttpGet httpget = new HttpGet("http://httpbin.org/");

        System.out.println("Executing request " + httpget.getRequestLine());

        // Create a custom response handler
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }

        };
        String responseBody = null;
        try {
            responseBody = httpclient.execute(httpget, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
    }


}