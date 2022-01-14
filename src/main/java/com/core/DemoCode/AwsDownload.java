package com.core.DemoCode;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author: jq.w
 * @Date: 2021/12/24 16:03
 * @Description:
 */
public class AwsDownload {

    private static String accessKeyId = "55DIWBJB0X4U249D8DD0";
    private static String secretKeyId = "52NLJIBoVrGtC25xpIeREclO25pXIdjGEYtM83vT";
    private static String bucketName = "/zqt-data-prod";
    private static String objectKey = "/test/upload-test.zip";
    private static String serviceEndpoint = "https://ods.lianjia.com";


    public static void main(String[] args) throws UnsupportedEncodingException {

        long exp = 259200;
        long time = 1591345015;
        System.out.println(getSignedUrl(serviceEndpoint, objectKey, accessKeyId, secretKeyId, time, exp));
    }

    private static String getSignedUrl(String domain, String path, String ak, String sk, long time, long exp) throws UnsupportedEncodingException {

        StringBuilder signBuilder = new StringBuilder();
        signBuilder.append("ak=").append(ak)
                .append("&exp=").append(exp)
                .append("&path=").append(URLDecoder.decode(path, "UTF-8"))
                .append("&ts=").append(time)
                .append("&sk=").append(sk);
        String sign = DigestUtils.md5DigestAsHex(signBuilder.toString().getBytes());

        StringBuilder paramBuilder = new StringBuilder();
        paramBuilder.append("ak=").append(ak)
                .append("&exp=").append(exp)
                .append("&ts=").append(time);
        String params = paramBuilder.append("&sign=").append(sign).toString();

        if (!domain.contains("http://") && !domain.contains("https://")) {
            domain = "http://" + domain;
        }
        return domain.endsWith("/") ? domain.substring(0, domain.length() - 1) + path + '?' + params : domain + path + '?' + params;
    }


}
