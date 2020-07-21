package com.bosssoft.mytask.dao;

import com.bosssoft.mytask.entity.Task;
import java.util.List;


public interface TaskDao {

    /**
     *增加条目的方法
     */
    void addTask(Task task);

    /**
     *  查询条目的方法
     */
    List<Task> findAll();

    /**
     * 删除条目的方法
     */
    void deleteTaskByName(String name);

    /**
     * 获取商品名
     * @return 商品名List
     */
    List<String> getItemName();

    /**
     * 由商品名获取商品数量
     * @param name
     * @return 商品数量
     */
    Integer getItemNum(String name);

    /**
     * 由商品名获取商品单价
     * @param name 商品名
     * @return price 商品单价price
     */
    double getItemPrice(String name);
}
