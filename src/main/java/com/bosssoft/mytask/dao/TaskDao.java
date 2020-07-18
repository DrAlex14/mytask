package com.bosssoft.mytask.dao;

import com.bosssoft.mytask.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface TaskDao {

    //增加条目的方法
    void addTask(Task task);


    //查询条目的方法
    List<Task> findAll();


    //删除条目的方法
    void deleteTaskByName(String name);

    List<String> getItemName();

    Integer getItemNum(String name);

    double getItemPrice(String name);

    //查询单条目的方法
    //Task selectTaskByName(String name);
}
