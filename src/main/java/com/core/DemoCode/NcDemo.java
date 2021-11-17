package com.core.DemoCode;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.thymeleaf.expression.Maps;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class NcDemo {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap();
//        map.put("82", "NBBL");
//        map.put("33", "CZTN");
//        map.put("45", "CDQY");
//        map.put("29", "NBCX");
//        map.put("93", "HUDQ");
//        map.put("56", "JXHN");
//        map.put("81", "NBHS");
//        map.put("23", "HZGS");
//        map.put("104", "HZWYXLYH");
//        map.put("44", "HFSS");
//        map.put("55", "HUWX");
//        map.put("95", "JXJS");
//        map.put("52", "JXNH");
//        map.put("103", "QZJS");
//        map.put("87", "JHYFJD");
//        map.put("94", "QZKH");
//        map.put("88", "SXKX");
//        map.put("120", "WZLQ");
//        map.put("60", "LSLD");
//        map.put("24", "CXLH");
//        map.put("101", "QZLY");
//        map.put("80", "TXLQ");
//        map.put("38", "NJYHT");
//        map.put("84", "HUNX");
//        map.put("63", "NBYZ");
//        map.put("47", "YZSXQ");
//        map.put("102", "WZRA");
//        map.put("100", "SXSY");
//        map.put("34", "SXYC");
//        map.put("25", "BYSZ");
//        map.put("39", "SZWZ");
//        map.put("43", "TXSX");
//        map.put("96", "JXTX");
//        map.put("26", "TZWL");
//        map.put("41", "WZOH");
//        map.put("20", "WXLX");
//        map.put("40", "WHHS");
//        map.put("92", "NBXS");
//        map.put("72", "CXXS");
//        map.put("132", "XC");
//        map.put("27", "YZSX");
//        map.put("59", "NBYY");
//        map.put("85", "HUCX");
//        map.put("28", "ZSSX");
//        map.put("31", "SXZJ");
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            String sql = "UPDATE `t_nc_department` SET `voucher_maker`='" + entry.getValue() + "', `who_modified` ='wjq'  WHERE `company_id` =1000002 AND `deleted` = 0 AND `branch_company_id` =" + entry.getKey() + ";";
//            System.err.println(sql);
//
//        }
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.AbortPolicy());
//
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                for (Integer integer : list) {
//                    System.err.println(integer);
//                }
//            }
//        });

//        System.err.println(Optional.ofNullable("111").orElse             "22222"));
//        System.err.println(Optional.ofNullable(null).orElse("22222"));
//        System.err.println(Optional.ofNullable(null).orElseGet());

//        String a = "<其他门店不可使用>";
//        String s = StringEscapeUtils.escapeHtml4(a);
//        System.err.println(s);

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(3000, 1, 1);
//        Date time = calendar.getTime();
//
//        System.err.println(DateFormatUtils.format(time,"yyyy-MM-dd HH:mm:ss"));
//        System.err.println(2750%16);

//        String jsonStr = "[1001783,1001784]";
//        List<Long> longs = JSONArray.parseArray(jsonStr, Long.class);
//        for (Long aLong : longs) {
//            System.err.println(aLong);
//        }

        String paramstr = "{\"keCode\":\"100100100\"}";
        Map<String, Object> params = JSONObject.parseObject(paramstr);
        System.err.println(params.get("keCode").toString());

    }
}

//class  A implements Callable{
//
//    @Override
//    public Object call() throws Exception {
//        return null;
//
//    }
//}