package com.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 */
public class FileUtil {

    /**
     * 文件上传
     *
     * @param url      上传地址
     * @param filePath 文件地址
     * @return
     */
    public static String upload(String url, String filePath) {
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpPost httppost = new HttpPost(url);
            FileBody file = new FileBody(new File(filePath));
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", file);
            httppost.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(httppost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                System.out.println("服务器正常响应.....");
                HttpEntity resEntity = response.getEntity();
                // 这里是服务端的返回值
                System.out.println(resEntity.getContent());
                // httpclient自带的工具类读取返回数据
                String result = EntityUtils.toString(resEntity);
                // EntityUtils.consume(resEntity);
                return result;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.getConnectionManager().shutdown();
            } catch (Exception ignore) {

            }
        }
        return null;
    }

}