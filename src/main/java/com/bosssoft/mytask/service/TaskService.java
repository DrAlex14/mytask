package com.bosssoft.mytask.service;

import com.bosssoft.mytask.entity.Task;

import java.util.List;

public interface TaskService {

    /**
     * 增加条目
     */
    void addTask(Task task);

    /**
     * 查询方法
     */
    List<Task> findAll();

    /**
     * 删除条目
     */
    void deleteTaskByName(String name);

    /**
     * 计算条目总价
     */
    void totalPrice(List<Task> tasks);
}
