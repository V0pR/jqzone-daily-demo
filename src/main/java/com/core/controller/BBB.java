package com.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.fc.csplatform.common.crypto.Base64Util;
import com.alipay.fc.csplatform.common.crypto.CustomerInfoCryptoUtil;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

/**
 * @author wjq
 * @version 1.0
 * @Title: BBB
 * @Package com.core.controller
 * @Description:
 * @date 2020/4/9 15:15
 */
public class BBB {

    //注意：该公钥仅供demo示范使用，用户公钥请参考文档第四部分，收集信息，联系开发同学获取。
    private static String pub_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp5khaVZIP+x+n+ari3c1dcYRuNG7BUL0VVt1X2+KDcOpTHtfdHUQIzrHdbikZSyaCKyHLbAuLsU24gulCKmMGtjFGS6OiavUFFikVnVnOyEzcnhSPBiJNdlUo5TNYOVN1SUCutJUxvibQ1za6IcnHf4okgPTgcrXVHyG5ntCbE9ippKLe7q0z0TUIkRxesbKZiQPBDOgBukJUiFMk95zqCdESCe6kCSp2GdIojyVAelU11JIcAm/4OjCCFMz6Jcnse7rdScxRsoMHU89tDmXG9mo3PhUXyfQJzyESlotKek99eHPkSr7EW/SBj3xMc+ysrBZd+4tFOZJIRIlFf/eSQIDAQAB";
    //还原出RSA公钥对象
    private static PublicKey getPubKey() throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64Util.decode(pub_key));
        KeyFactory keyFactory;
        keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);
        return key;
    }
    public static void main(String[] args) throws Exception {
        JSONObject extInfo = new JSONObject();
        extInfo.put("uid", "11111");
        extInfo.put("customerInfo","11111");

        JSONObject cinfo = new JSONObject();
        cinfo.put("userId", "12345");
        extInfo.put("uname","张三");
        PublicKey publicKey = getPubKey();
        Map<String, String> map = CustomerInfoCryptoUtil.encryptByPublicKey(cinfo.toString(), publicKey);
        String uri = "&key=" + map.get("key") + "&cinfo=" + map.get("text");
        System.err.println("https://cschat-ccs.aliyun.com/index.htm?tntInstId=_0TN5icC&scene=SCE00003133"+uri);
    }
}
