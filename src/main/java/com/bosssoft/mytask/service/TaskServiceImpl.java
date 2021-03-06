package com.bosssoft.mytask.service;


import com.bosssoft.mytask.dao.TaskDao;
import com.bosssoft.mytask.entity.Task;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
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
       for(Task task:tasks){
           double price = taskDao.getItemPrice(task.getName());
           Integer num = taskDao.getItemNum(task.getName());
           double totalprice = price * num ;
           task.setTotalprice(totalprice);
       }
    }
}
