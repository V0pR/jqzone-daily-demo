package com.core.DemoCode;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;

/**
 * @Author: jq.w
 * @Date: 2021/12/24 16:03
 * @Description:
 */
public class AwsDownload {

    private static String accessKeyId = "111";
    private static String secretKeyId = "222";
    private static String bucketName = "/zqt-data-daily";
    private static String objectKey = "/test/20220217.pdf";
    private static String serviceEndpoint = "https://ods.lianjia.com";

    public static void main(String[] args) throws IOException {

        long exp = 259200;
        Long time = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.err.println(time);
        System.out.println(getSignedUrl(serviceEndpoint, objectKey, accessKeyId, secretKeyId, time, exp));
        System.err.println(exp/60/60);
    }

    private static String getSignedUrl(String serviceEndpoint, String objectKey, String ak, String sk, long time, long exp) throws IOException {
        objectKey = bucketName.concat(objectKey);
        StringBuilder signBuilder = new StringBuilder();
        signBuilder.append("ak=").append(ak)
                .append("&exp=").append(exp)
                //防止特殊字符-特殊字符（中文）需要进行urldecode
                .append("&path=").append(URLDecoder.decode(objectKey, "UTF-8"))
                .append("&ts=").append(time)
                .append("&sk=").append(sk);
        String sign = DigestUtils.md5DigestAsHex(signBuilder.toString().getBytes());

        System.err.println(sign);
        StringBuilder paramBuilder = new StringBuilder();
        paramBuilder.append("ak=").append(ak)
                .append("&exp=").append(exp)
                .append("&ts=").append(time);
        String params = paramBuilder.append("&sign=").append(sign).toString();

        if (!serviceEndpoint.contains("http://") && !serviceEndpoint.contains("https://")) {
            serviceEndpoint = "http://" + serviceEndpoint;
        }
        String urlString = serviceEndpoint.endsWith("/") ? serviceEndpoint.substring(0, serviceEndpoint.length() - 1) + objectKey + '?' + params : serviceEndpoint + objectKey + '?' + params;
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        FileUtils.copyInputStreamToFile(inputStream, new File("/Users/qqjqq/Downloads/2222.pdf"));
        return urlString;
    }



}
