package com.core.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author wjq
 * @version 1.0
 * @Title: Base64Utils
 * @Package com.zqt.security
 * @Description: base64加密
 * @date 2020/1/3 17:59
 */
public class Base64Utils {


    /**
     * 加密
     * json的报文不允许有换行，base64会产生。因此此处做去换行处理。
     *
     * @param content 内容
     * @return
     * @throws Exception
     */
    public static String encryption(String content) throws UnsupportedEncodingException {
        return new BASE64Encoder()
                .encodeBuffer(content.getBytes("UTF-8"))
                .replace("\r\n", "").replace("\n", "").replace("\r", "");
    }

    /**
     * 加密key
     * json的报文不允许有换行，base64会产生。因此此处做去换行处理。
     *
     * @param contentMD5
     * @return
     * @throws Exception
     */
    public static String contentKey(String contentMD5, String contentKey) throws Exception {
        return AESUtils.encryptBASE64(AESUtils.encrypt(contentMD5.getBytes("UTF-8"), contentKey))
                .replaceAll("\r\n", "").replaceAll("\n", "")
                .replace("\r", "");
    }

    /**
     * 解密
     *
     * @param content
     * @return
     */
    public static String decryption(String content) {
        String s = null;
        try {
            s = new String(new BASE64Decoder().decodeBuffer(content), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
