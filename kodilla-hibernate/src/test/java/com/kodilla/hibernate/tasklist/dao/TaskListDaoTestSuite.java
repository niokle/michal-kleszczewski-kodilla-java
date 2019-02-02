package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //given
        String taskListDescription1 = "Zadania do realizacji";
        String taskListDescription2 = "W trakcie realizacji";

        TaskList taskList1 = new TaskList("ToDo", taskListDescription1);
        TaskList taskList2 = new TaskList("In Progress", taskListDescription2);

        //when
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);

        //then
        Assert.assertEquals(taskListDescription1, taskListDao.findByListName("ToDo").get(0).getDescription());
        Assert.assertEquals(taskListDescription2, taskListDao.findByListName("In Progress").get(0).getDescription());

        //cleanUp
        taskListDao.delete(taskListDao.findByListName("ToDo").get(0).getId());
        taskListDao.delete(taskListDao.findByListName("In Progress").get(0).getId());
    }
}