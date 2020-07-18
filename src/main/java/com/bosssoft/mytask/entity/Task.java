package com.bosssoft.mytask.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Data //生成getter,setter等函数
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Accessors(chain = true)
@ToString
public class Task {
    private String name;
    private Integer typeid;
    private Integer num;
    private String location;
    private String time;

//    public Task(String name,Integer typeid,Integer num,String location,String time){
//        this.name = name;
//        this.typeid = typeid;
//        this.num = num;
//        this.location = location;
//        this.time = time;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getTypeid() {
//        return typeid;
//    }
//
//    public void setTypeid(int typeid) {
//        this.typeid = typeid;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
}
