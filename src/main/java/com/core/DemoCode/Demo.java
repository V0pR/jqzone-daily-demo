package com.core.DemoCode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author v0pr
 */
public class Demo {

    public static void main(String[] args) throws IOException, ParseException {
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
//        System.err.println(DesensitizationUtils.mobilePhone("173202012312"));
//        System.err.println(DesensitizationUtils.address("新湖·香格里拉1-3-2101"));
//
//        System.err.println(DesensitizationUtils.fixedPhone("123"));
//
//        System.err.println(DesensitizationUtils.userName("王建强"));

//        try {
//            BigDecimal a =new BigDecimal(1);
//            System.err.println(a.divide(BigDecimal.ZERO));
//        }catch (Exception e){
//            System.err.println(String.format("QuoteId: %s",e.getMessage()));
//        }
//        BigDecimal a = null;
//
//        if (Objects.isNull(a)  ||  a.setScale(2).compareTo(BigDecimal.ZERO) == 0){
//            System.err.println(111);
//        }
//
//
//
//        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource(""));
//        bf.getBean("");
//
//        String[] specifiedProfiles = StringUtils.tokenizeToStringArray(
//                "profile", BeanDefinitionParserDelegate.MULTI_VALUE_ATTRIBUTE_DELIMITERS);
//        for (String specifiedProfile : specifiedProfiles) {
//            System.err.println(specifiedProfile);
//        }

        //获取当前时间-在这里可以增加或者减少时间求出非当前天的最大时间.plusDays()
//        System.err.println(  DateUtils.addDays(getToDayEndTimeDate(LocalDateTime.now()), 15));
//        b a = new b();
//        System.err.println(Optional.ofNullable(a.getA().getAge()).orElse(null));
//    }


//    public static Date getToDayEndTimeDate(   LocalDateTime localDateTime) {
//        //获取当前时间-在这里可以增加或者减少时间求出非当前天的最大时间.plusDays()
//        LocalDateTime day = localDateTime.with(LocalTime.MAX);
//        return Date.from(day.atZone(ZoneId.systemDefault()).toInstant());
//    }
//
//
//
//        List<A> list = new ArrayList<>();
//
//        A a = new A();
//        a.setAge("1");
//        A b = new A();
//        b.setAge("2");
//        list.add(a);
//        list.add(b);
//        StringJoiner joiner = new StringJoiner(",");
//        list.stream().forEach(project -> joiner.add(project.getAge()));
//        System.err.println(joiner.toString());

        //
        //List<Long> list = Arrays.asList(289686L,
        //        280712L,
        //        275868L,
        //        274200L,
        //        274120L,
        //        274098L,
        //        273160L,
        //        272398L,
        //        272292L,
        //        269265L,
        //        267650L,
        //        267418L,
        //        267231L,
        //        264597L,
        //        263533L,
        //        258921L,
        //        257548L,
        //        254333L,
        //        242851L,
        //        217516L);
        //Map<Long, Long> map = Maps.newHashMap();
        //map.put(289686L,2645L);
        //map.put(280712L,0L);
        //map.put(275868L,2645L);
        //map.put(274200L,4600L);
        //map.put(274120L,4600L);
        //map.put(274098L,3450L);
        //map.put(273160L,3910L);
        //map.put(272398L,21160L);
        //map.put(272292L,4255L);
        //map.put(269265L,3680L);
        //map.put(267650L,4945L);
        //map.put(267418L,2760L);
        //map.put(267231L,3450L);
        //map.put(264597L,4370L);
        //map.put(263533L,0L);
        //map.put(258921L,4830L);
        //map.put(257548L,3220L);
        //map.put(254333L,0L);
        //map.put(242851L,0L);
        //map.put(217516L,3450L);
        //for (Long id : list) {
        //    Long aLong = map.get(id);
        //    if (Objects.isNull(aLong)) {
        //        System.err.println("error:" + id);
        //        return;
        //    }
        //    String sql = "UPDATE `mj_cost_control` SET `actual_amount` =" + aLong + ", `coupon_change_amount` =" + aLong + " WHERE `project_id` ="+id+" AND `category_id` = 1000001612;";
        //    System.err.println(sql);
        //}
        //System.err.println("-- 软装内控设置为0");



//        System.err.println(new BigDecimal(122417.4800).multiply(new BigDecimal(0.005))
//                .setScale(2, RoundingMode.HALF_UP));
//       responsewra= "[{id=04eac0f7-9bbe-4e63-97e8-fb8ef799b0ba_1024, pt=1625785200000, companyId=1000002, branchCompanyId=42, branchCompanySimpleName=金华第一分公司义乌小组, projectId=215775, constructionStatus=FINISH_CHECKING, currentStageName=竣工验收, name=安福家园5-1-1004, departmentRegionId=191, departmentRegionName=雷霆大区, departmentCityId=226, departmentCityName=义乌店, departmentBusinessId=404, departmentBusinessName=义乌事业三部, projectConfType=ALL, houseType=FLAT_LAYER, area=122.0, contractAmount=195000.0, expiredRunningTime=1618588800000, prepareStageEndDate=1618645103000, contractPlanDays=120, checkExpectEndDate=1629013103000, waterMaterialFirstPlaceOrderDate=1618655024000, completionCheckPeriodStandardDays=100, completionCheckPeriodExpectDoneDate=1627295024000, completionCheckPeriodDoneDate=1625556444000, ownerCheckTime=1625630579000, completionCheckPeriodActualDays=80, completionCheckPeriodHasSpringFestival=0, completionCheckPeriodTimeLimitCount=-20, woodworkerId=1010209, woodworkerName=李海威, engineeringManagerId=1008617, engineeringManagerName=厉秀伟, projectManagerId=1007401, projectManagerName=翟进双, inspectorId=1013332, inspectorName=马继东, contractPlanStartDate=null, contractPlanEndDate=null, contractPlanTimeLimitCount=null}, " +
//                "{id=81566046-9b06-43b3-8673-eaaeadc82880_787, pt=1625785200000, companyId=1000002, branchCompanyId=20, branchCompanySimpleName=圣都无锡分公司, projectId=204317, constructionStatus=FINISH_CHECKING, currentStageName=竣工验收, name=时代雅居19-3103, departmentRegionId=198, departmentRegionName=杭州大区, departmentCityId=215, departmentCityName=无锡店, departmentBusinessId=4449, departmentBusinessName=无锡纳米五部, projectConfType=ALL, houseType=FLAT_LAYER, area=128.0, contractAmount=192000.0, expiredRunningTime=1614700800000, prepareStageEndDate=1615608915000, contractPlanDays=120, checkExpectEndDate=1625976915000, waterMaterialFirstPlaceOrderDate=1615173539000, completionCheckPeriodStandardDays=100, completionCheckPeriodExpectDoneDate=1623813539000, completionCheckPeriodDoneDate=1625472639000, ownerCheckTime=1625576083000, completionCheckPeriodActualDays=119, completionCheckPeriodHasSpringFestival=0, completionCheckPeriodTimeLimitCount=19, woodworkerId=1036632, woodworkerName=宋加兵, engineeringManagerId=1009279, engineeringManagerName=刘旺达, projectManagerId=1022018, projectManagerName=蔡德润, inspectorId=1009277, inspectorName=蔡明理, contractPlanStartDate=null, contractPlanEndDate=null, contractPlanTimeLimitCount=null}, " +
//                "{id=8552ba07-f406-4557-8a5c-6a3be5eac59f_911, pt=1625785200000, companyId=1000002, branchCompanyId=72, branchCompanySimpleName=圣都萧山分公司, projectId=205691, constructionStatus=FINISH_CHECKING, currentStageName=竣工验收, name=苏家谭小区3-1-401, departmentRegionId=194, departmentRegionName=赤霄大区, departmentCityId=203, departmentCityName=萧山店, departmentBusinessId=379, departmentBusinessName=萧山旗舰四部, projectConfType=ALL, houseType=FLAT_LAYER, area=70.0, contractAmount=137300.0, expiredRunningTime=1618416000000, prepareStageEndDate=1620093850000, contractPlanDays=100, checkExpectEndDate=1628733850000, waterMaterialFirstPlaceOrderDate=1618553136000, completionCheckPeriodStandardDays=95, completionCheckPeriodExpectDoneDate=1626761136000, completionCheckPeriodDoneDate=1625445679000, ownerCheckTime=1625486963000, completionCheckPeriodActualDays=80, completionCheckPeriodHasSpringFestival=0, completionCheckPeriodTimeLimitCount=-15, woodworkerId=1023911, woodworkerName=袁茂环, engineeringManagerId=1002293, engineeringManagerName=蒋海峰, projectManagerId=1025688, projectManagerName=李明刚, inspectorId=1032030, inspectorName=林正刚, contractPlanStartDate=null, contractPlanEndDate=null, contractPlanTimeLimitCount=null}]";
//        ArrayList list = (ArrayList) o;
//        for (Object o1 : list) {
//            Map m = (LinkedHashMap) o1;
//            JSONObject jsonObject = JSONObject.parseObject(m.toString());
//            System.err.println(jsonObject);
//        }


//        LocalDateTime firstDayOfMonth = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
//        Date from = Date.from(firstDayOfMonth.with(LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
//        System.err.println(from);
//        System.err.println(from.getTime());


//        BigDecimal bigDecimal = new BigDecimal(2020.2000);
//        BigDecimal bigDecimal1 = new BigDecimal(2020.2000);
//        if (bigDecimal.compareTo(bigDecimal1) <= 0) {
//            System.err.println(111);
//        }

//        String aa ="$!{";
//        String replace = aa.replace("$!{", "$!{");
//        System.err.println(replace);
//
//        LocalDateTime localDateTime = LocalDateTime.of(2021, 8, 31, 23, 59, 59);
//
//        LocalDateTime day = localDateTime.with(LocalTime.MAX);
//        Date from = Date.from(day.atZone(ZoneId.systemDefault()).toInstant());
////        System.err.println();
//        System.err.println(from);
//        System.err.println(from.after(new Date()));
//        double exp = Math.exp(300);
//        System.err.println(exp);
//        int a = (int) exp;
//        System.err.println(a);
//        int max = Math.max(Math.min(a, 1), 24 * 60);
//        System.err.println(max);
//        int periodMinutes = max;
//        System.err.println(periodMinutes);
//        System.err.println( new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(periodMinutes, TimeUnit.MINUTES)));

        //String m_fit ="m_fit";
        //String m_fill = "m_fill";
        //
        ArrayList<String> values = Lists.newArrayList("w_160,h_160",
                "w_524",
                "w_132,h_132",
                "h_300",
                "w_400,h_400",
                "w_186,h_186",
                "w_690,h_390",
                "w_84,h_84",
                "w_80,h_80",
                "w_110,h_110",
                "w_690",
                "w_750",
                "w_375"
        );
        //
        //for (String value : values) {
        //    System.err.println(m_fit+","+value);
        //}
        //File file1 = new File("/Users/qqjqq/Downloads/grafana_data_export.csv");
        //InputStream inputStream = new FileInputStream(file1);
        //System.err.println(file1.getName());
        //String mimeType = URLConnection.guessContentTypeFromName(file1.getName());
        //System.err.println(mimeType);
        //StringJoiner joiner = new StringJoiner("、 ");
        //values.forEach(s->joiner.add(s));
        //System.err.println("投诉"+joiner);

        String a ="{noticeListenerName=beKeComplaintService, amqp_receivedDeliveryMode=PERSISTENT, outBizId=179, amqp_receivedExchange=engine, amqp_deliveryTag=2, Pinpoint-Sampled=1, bizCode=BE_KE, amqp_consumerQueue=engine.be_ke_complaint_input, amqp_redelivered=false, bizTime=1647496146433, amqp_receivedRoutingKey=engine, companyId=1000002, branchCompanyId=72, tag=PROJECT_COMPLAINT_SYNC_BE_KE, id=c1457810-7ced-cc2d-1baa-1e540152c2ce, amqp_consumerTag=amq.ctag-U5f2dpjOkT5U8u062Omb5A, contentType=application/x-java-object;type=java.util.HashMap, timestamp=1647496151450}";
        Map map = JSONObject.parseObject(a, Map.class);
        System.err.println(map);


    }

}
