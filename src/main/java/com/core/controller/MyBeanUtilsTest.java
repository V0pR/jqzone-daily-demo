package com.core.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyBeanUtilsTest {

    private static List<Person> list;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person implements Serializable {
        private String name;
        private Integer age;
        private Department department;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Department implements Serializable{
        private String name;
    }

    static {
        list = new ArrayList<>();
        list.add(new Person("笑脸", 18, new Department("行政部")));
    }

    public static void main(String[] args) {
        Person bean = list.get(0);
        Person copyBean = new Person();
        BeanUtils.copyProperties(bean, copyBean);
        //对象不一样 证明是新创建的一个对象
        System.out.println(bean == copyBean);

        System.out.println("==== copyBean的属性 ====");
        System.out.println(copyBean.getName());
        System.out.println(copyBean.getDepartment().getName());

        bean.setName("哭脸");
        bean.getDepartment().setName("财务部");

        System.out.println("==== sourceBean修改后，copyBean的属性 ====");
        System.out.println(copyBean.getName());
        System.out.println(copyBean.getDepartment().getName());
    }
}
