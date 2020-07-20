package com.bosssoft.mytask.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data //生成getter,setter等函数
//@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Accessors(chain = true)
@ToString
public class Task {
    private String name;
    private Integer typeid;
    private Integer num;
    private String location;
    private String time;
    private double totalprice;

    public Task(String name,Integer typeid,Integer num,String location,String time){
        this.name = name;
        this.typeid = typeid;
        this.num = num;
        this.location = location;
        this.time = time;
    }

}
