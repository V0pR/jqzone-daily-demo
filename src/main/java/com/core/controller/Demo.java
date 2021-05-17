package com.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.core.common.exception.BizException;
import com.core.utils.DesensitizationUtils;
import org.apache.commons.lang3.StringUtils;
import org.thymeleaf.util.MapUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author v0pr
 */
public class Demo {

    public static void main(String[] args) {
//
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//            list.remove(i);
//        }
//
//        for (String value : list) {
//            if ("b".equals(value)) {
//                list.remove(value);
//            }
//        }
//
//        System.out.println(list);
//        String departmentIdStr = StringUtils.substringAfter("project_manager_department_111_NONE","project_manager_department_" );
//        String[] code = StringUtils.split(departmentIdStr, "_");
//        String s = code[0];
//        String s1 = code[1];
//
//        System.err.println(s);
//
//        System.err.println(s1);


//        List<String> valueList = Arrays.stream(StringUtils.split("72,63,32,23", ",")).collect(Collectors.toList());
//        System.err.println(valueList);
//        Long A = 23L;
////        System.err.println(valueList.contains(A.toString()));
//        try {
//            String o = "111";
//            if (o == null){
//                throw new BizException("你错了");
//            }
//            Optional<String> o1 = Optional.of(o);
//            System.err.println(o1.get());
//        }finally {
//            System.err.println("222");
//        }
//        System.err.println(33333);
//        System.err.println(DesensitizationUtils);
//        Integer a =null;
//        Integer b =2255;
//        System.err.println(Objects.equals(a,b));
        System.err.println(DesensitizationUtils.mobilePhone("17326021050"));
        System.err.println(DesensitizationUtils.address("新湖·香格里拉1-3-2101"));
        System.err.println(DesensitizationUtils.bankCard("6228480468633324370"));
        System.err.println(DesensitizationUtils.email("wangjq.email@qq.com"));
        System.err.println(DesensitizationUtils.fixedPhone("0832-98988"));
        System.err.println(DesensitizationUtils.idCardNum("511023199410015456"));
        System.err.println(DesensitizationUtils.userName("王建强"));

    }
}
