package com.bosssoft.mytask.controller;

import com.bosssoft.mytask.entity.Applicant;
import com.bosssoft.mytask.entity.Task;
import com.bosssoft.mytask.entity.jsonResult;
import com.bosssoft.mytask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Resource
    TaskService taskService;

    /**
     * 查询所有条目
     */
    @RequestMapping("findAll")
    @ResponseBody
    public jsonResult findAll(HttpSession session){
       List<Task> tasks = taskService.findAll();
       taskService.totalPrice(tasks);
        Applicant applicant = new Applicant();
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();
        df1.format(date);
        double TOTAL_PRICE = 0;
        for(Task task:tasks){
            TOTAL_PRICE += task.getTotalprice();
        }
       HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("applicantName",applicant.getApplicantName());
        hashMap.put("departName",applicant.getDepartName());
        hashMap.put("applicationdate",df1.format(date));
        hashMap.put("Tasks",tasks);
        hashMap.put("totalprice",TOTAL_PRICE);

       jsonResult jsonResult = com.bosssoft.mytask.entity.jsonResult.ok(hashMap);
       session.setAttribute("alltasks","jsonResult");

       return jsonResult.ok(hashMap);
    }

    /**
     * 添加条目
     */
    @PostMapping("addTask")
    public String addTask(String name,Integer typeid,Integer num,String location,String time){
        if(name!=null&&typeid!=null&&num!=null&&location!=null&&time!=null) {
            Task task = new Task(name,typeid,num,location,time);
            taskService.addTask(task);
        }
        return "redirect:/task/findAll";
    }

    /**
     * 修改条目
     */
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

    /**
     * 删除条目
     */
    @PostMapping("deleteTask")
    public String deleteTaskByName(String name){
       if(name!= null){
           taskService.deleteTaskByName(name);
       }
        return "redirect:/task/findAll";
    }
}
