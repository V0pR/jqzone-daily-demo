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
            return mobileNum;
        }
        if (StringUtils.length(mobileNum) < 11) {
            return mobileNum;
        }
        return StringUtils.left(mobileNum, 3).concat("****").concat(StringUtils.right(mobileNum, 4));
    }

    /**
     * 【固定电话 后四位，其他隐藏，比如1234
     *
     * @param fixedPhoneNum
     * @return
     */
    public static String fixedPhone(String fixedPhoneNum) {
        if (StringUtils.isBlank(fixedPhoneNum)) {
            return fixedPhoneNum;
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
            return fullName;
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
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
}
