package com.core.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaoXi
 * @Classname A
 * @Description TODO
 * @Date 2021/7/6 10:04 上午
 */
@Getter
@Setter
public class A {

    private B testB;

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void a(){
        testB.b();
    }


}
