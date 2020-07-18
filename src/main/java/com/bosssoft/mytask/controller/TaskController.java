package com.bosssoft.mytask.controller;

import com.bosssoft.mytask.entity.Task;
import com.bosssoft.mytask.entity.jsonResult;
import com.bosssoft.mytask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Resource
    TaskService taskService;


    //查询所有条目
    @RequestMapping("findAll")
    @ResponseBody
    public jsonResult findAll(Model model){
       List<Task> tasks = taskService.findAll();

       //model.addAttribute("tasks",tasks);
       //System.out.println("num"+tasks.size());
       return jsonResult.ok(tasks);
    }

    //添加条目
    @PostMapping("addTask")
    public String addTask(String name,Integer typeid,Integer num,String location,String time){
        if(name!=null&&typeid!=null&&num!=null&&location!=null&&time!=null)
        {

            Task task = new Task(name,typeid,num,location,time);
            taskService.addTask(task);
        }
        return "redirect:/task/findAll";
    }

    //修改条目
    @PostMapping("updateTask")
    public String updateTaskByName(String oldname,String name,Integer typeid,Integer num,String location,String time){
        if(oldname != null&&name!=null&&typeid!=null&&num!=null&&location!=null&&time!=null){
            //Task task = taskService.selectTaskByName(name);
            taskService.deleteTaskByName(oldname);
            Task task = new Task(name,typeid,num,location,time);
            taskService.addTask(task);

        }
        return "redirect:/task/findAll";
    }

    //删除条目
    @PostMapping("deleteTask")
    public String deleteTaskByName(String name){
       if(name!= null){
           taskService.deleteTaskByName(name);
       }
        return "redirect:/task/findAll";
    }
}
