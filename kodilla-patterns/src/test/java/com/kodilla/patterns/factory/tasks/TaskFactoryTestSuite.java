package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testDrivingTaskCreate() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        //when
        Task task = taskFactory.createTask("Driving");
        //then
        Assert.assertEquals("task 1", task.getTaskName());
    }

    @Test
    public void testPaintingTaskCreate() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        //when
        Task task = taskFactory.createTask("Painting");
        //then
        Assert.assertEquals("task 2", task.getTaskName());
    }

    @Test
    public void testShoppingTaskCreate() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        //when
        Task task = taskFactory.createTask("Shopping");
        //then
        Assert.assertEquals("task 3", task.getTaskName());
    }
}

