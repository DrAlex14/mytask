package com.bosssoft.mytask.service;


import com.bosssoft.mytask.dao.TaskDao;
import com.bosssoft.mytask.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{

    @Resource
    private TaskDao taskDao;

    @Override
    public void addTask(Task task) {
        taskDao.addTask(task);
    }

    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

    @Override
    public void deleteTaskByName(String name) {
        taskDao.deleteTaskByName(name);
    }

    @Override
    public void totalPrice(List<Task> tasks) {
       //List<Task> tasks = taskDao.findAll();
       for(Task task:tasks){
           double price = taskDao.getItemPrice(task.getName());
           Integer num = taskDao.getItemNum(task.getName());
           double totalprice = price * num ;
           task.setTotalprice(totalprice);
       }
    }

//    @Override
//    public Task selectTaskByName(String name) {
//        return taskDao.selectTaskByName(name);
//    }
}
