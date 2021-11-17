package com.core.DemoCode;

import com.core.domain.A;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author v0pr
 */
public class Demo {

    public static void main(String[] args) throws JsonProcessingException, ParseException {
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




//        List<Integer> list = Arrays.asList(1,
//                2,
//                3,
//                66,
//                70,
//                71,
//                109,
//                110,
//                114,
//                1662,
//                1891,
//                1898,
//                1899,
//                1974,
//                1987,
//                2047,
//                2048,
//                2119,
//                2148,
//                2471,
//                2583,
//                2647,
//                2785,
//                2942,
//                3039,
//                3084,
//                3090,
//                3093);
//        for (Integer integer : list) {
//            String sql = "(1000003, " + integer + ", 1, 'SETTLEMENT_PROJECT_MANAGER_SATISFACTION_PUNISHMENT_AUTO_CONFIRM', 'ON', '分公司-项目经理满意度处罚自动勾选配置', 1, now(), now(), 'wjq', 'wjq', 0),";
//            System.err.println(sql);
//        }


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

        LocalDateTime localDateTime = LocalDateTime.of(2021, 8, 31, 23, 59, 59);

        LocalDateTime day = localDateTime.with(LocalTime.MAX);
        Date from = Date.from(day.atZone(ZoneId.systemDefault()).toInstant());
//        System.err.println();
        System.err.println(from);
        System.err.println(from.after(new Date()));
    }

}
