package com.core.DemoCode.contract;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Author: jq.w
 * @Date: 2022/3/7 10:58
 * @Description:
 */
public class FileHelper {
    public static String md5(String document) {

        try (BufferedInputStream fis = new BufferedInputStream(Files.newInputStream(Paths.get(document)))) {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md5.update(buffer, 0, length);
            }
            return Base64.getEncoder().encodeToString(md5.digest());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String getSignature(String data, String key, String algorithm, String encoding) {
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(encoding), "HmacSHA256");
            mac.init(secretKey);
            mac.update(data.getBytes(encoding));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("获取Signature签名信息异常：" + e.getMessage());
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("获取Signature签名信息异常：" + e.getMessage());
            return null;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            System.out.println("获取Signature签名信息异常：" + e.getMessage());
            return null;
        }
        return byte2hex(mac.doFinal());
    }

    public static String byte2hex(byte[] data) {
        StringBuilder hash = new StringBuilder();
        String stmp;
        for (int n = 0; data != null && n < data.length; n++) {
            stmp = Integer.toHexString(data[n] & 0XFF);
            if (stmp.length() == 1)
                hash.append('0');
            hash.append(stmp);
        }
        return hash.toString();
    }

    public static byte[] fileContent(String document) {

        try (BufferedInputStream fis = new BufferedInputStream(Files.newInputStream(Paths.get(document)))) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            return buffer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] fileContent(InputStream inputStream) {

        try (BufferedInputStream fis = new BufferedInputStream(inputStream)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            return buffer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String path(String... path) {
        return String.join("", path);
    }

}
