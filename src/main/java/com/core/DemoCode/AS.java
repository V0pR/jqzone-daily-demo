package com.core.DemoCode;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.xmpbox.type.OECFType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jq.w
 * @Date: 2022/1/6 18:58
 * @Description:
 */
public class AS {


    private static final WriteSheet writeSheet = com.alibaba.excel.EasyExcel.writerSheet().build();


    public static void main(String[] args) {

//        String fileName = "E:/22222.xlsx";
//        List<List<Object>> data = new ArrayList<>();
//        data.add(Arrays.asList("121332", "222", "333"));
//        data.add(Arrays.asList("111", "222", "333"));
//        data.add(Arrays.asList("111", "222", "333"));
//        List<String> head = Arrays.asList("表头1", "表头2", "表头3");
//        writeSimpleBySheet(fileName, data, head);
        fillExcel();

    }


    public static void writeSimpleBySheet(String filePath, List<List<Object>> data, List<String> head) {
        if (head != null) {
            List<List<String>> list = new ArrayList<>();
            //排除其他多余的对象
            head.forEach(h -> list.add(Collections.singletonList(h)));
            writeSheet.setHead(list);
        }

        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            com.alibaba.excel.EasyExcel.write(outputStream).build()
                    .write(data, writeSheet).finish();
        } catch (FileNotFoundException e) {
            //log.error("找不到文件或文件路径错误, 文件：{}", filePath);
            System.err.println("找不到文件或文件路径错误, 文件");
        } catch (IOException e) {
            //log.error("excel文件导出失败, 失败原因：{}", e);
            System.err.println("excel文件导出失败");
            e.printStackTrace();
        }
    }


    public static void fillExcel() {
        System.err.println("start" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        String fileName = "/Users/qqjqq/Downloads/dasdas.xlsx";
        String tmp = "/Users/qqjqq/Downloads/tmp/22222.xlsx";

        ExcelWriter excelWriter = com.alibaba.excel.EasyExcel.write(fileName).withTemplate(tmp).build();


        FillConfig fillConfig = FillConfig.builder().build();
        excelWriter.fill(data(), fillConfig, writeSheet);
        excelWriter.finish();
        System.err.println("end：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    private static ArrayList<Map<String, Object>> data() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("age",111);
        map.put("name","aaa");
        list.add(map);
        return list;
        //
        //
        //List<Demo1> list = new ArrayList<>();
        //
        //for (int i = 0; i < 20000; i++) {
        //    Demo1 student = new Demo1();
        //    student.setName("瓜田李下 " + i);
        //    student.setAge(20 + i);
        //
        //    list.add(student);
        //}
        //
        //return list;
    }
}

@Data
class Demo1 {
    private int age;
    private String name;
}