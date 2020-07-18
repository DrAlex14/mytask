package com.bosssoft.mytask;

import com.bosssoft.mytask.dao.TaskDao;
import com.bosssoft.mytask.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = MytaskApplication.class)
@RunWith(SpringRunner.class)
public class TestTaskDao {

    @Resource
    private TaskDao taskDao;

    @Test
    public void testSave(){
        taskDao.addTask(new Task("电脑",1,10,"广州","2020-07-20"));
    }
}
