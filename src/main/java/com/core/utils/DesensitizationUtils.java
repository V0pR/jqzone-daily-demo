package com.core.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author xiaoXi
 * @Classname DesensitizationUtils
 * @Description 脱敏方法工具类
 * @Date 2021/5/13 2:24 下午
 */
public class DesensitizationUtils {

    /**
     * 脱敏手机号码
     *
     * @param mobileNum
     * @return
     */
    public static String mobilePhone(String mobileNum) {
        if (StringUtils.isBlank(mobileNum)) {
            return null;
        }
        if (StringUtils.length(mobileNum) <= 7) {
            return mobileNum;
        }

        return StringUtils.left(mobileNum, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(mobileNum, 4), StringUtils.length(mobileNum), "*"), "***"));
    }

    /**
     * 【固定电话 后四位，其他隐藏，比如1234
     *
     * @param fixedPhoneNum
     * @return
     */
    public static String fixedPhone(String fixedPhoneNum) {
        if (StringUtils.isBlank(fixedPhoneNum)) {
            return null;
        }
        return StringUtils.leftPad(StringUtils.right(fixedPhoneNum, 4), StringUtils.length(fixedPhoneNum), "*");
    }


    /**
     * 脱敏名称
     * 比如：李**
     *
     * @param fullName
     * @return
     */
    public static String userName(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return null;
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }


    /**
     * 身份证脱敏
     *
     * @param idCardNum
     * @return
     */
    public static String idCardNum(String idCardNum) {
        if (StringUtils.isBlank(idCardNum)) {
            return null;
        }
        String num = StringUtils.right(idCardNum, 4);
        return StringUtils.leftPad(num, StringUtils.length(idCardNum), "*");
    }

    /**
     * 项目地址脱敏
     *
     * @param address
     * @return
     */
    public static String address(String address) {
        if (StringUtils.isBlank(address)) {
            return null;
        }
        return address.replaceAll("[0-9a-zA-Z]", "*");
    }

    /**
     * email 脱敏
     *
     * @param email
     * @return
     */
    public static String email(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1) {
            return email;
        }
        return StringUtils.rightPad(StringUtils.left(email, 1), index, "*").concat(StringUtils.mid(email, index, StringUtils.length(email)));
    }

    /**
     * 银行卡号脱敏
     *
     * @param cardNum
     * @return
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return null;
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }
}
