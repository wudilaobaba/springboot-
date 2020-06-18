package com.whj.springbootcode.sample.hero;

import com.whj.springbootcode.sample.ISkill;

public class Camille implements ISkill {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void q(){
        System.out.println("Camille's Q");
    }
    public void w(){
        System.out.println("Camille's W");
    }
    public void e(){
        System.out.println("Camille's E");
    }
    public void r(){
        System.out.println("Camille's R");
    }
}
