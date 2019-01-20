package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {
    @Test
    public void testToDoListBeanExist() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //when
        long numberOfToDoListBean = Arrays.stream(context.getBeanDefinitionNames())
                .filter(c -> c.contains("toDoList"))
                .count();
        //then
        Assert.assertEquals(1, numberOfToDoListBean);
    }

    @Test
    public void testInProgressListBeanExist() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //when
        long numberOfInProgressListBean = Arrays.stream(context.getBeanDefinitionNames())
                .filter(c -> c.contains("inProgressList"))
                .count();
        //then
        Assert.assertEquals(1, numberOfInProgressListBean);
    }

    @Test
    public void testDoneListBeanExist() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //when
        long numberOfDoneListBean = Arrays.stream(context.getBeanDefinitionNames())
                .filter(c -> c.contains("doneList"))
                .count();
        //then
        Assert.assertEquals(1, numberOfDoneListBean);
    }

    @Test
    public void testTaskAdd() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //when
        board.getToDoList().addTask("Task1");
        board.getInProgressList().addTask("Task2");
        board.getInProgressList().addTask("Task3");
        board.getDoneList().addTask("Task4");
        board.getDoneList().addTask("Task5");
        board.getDoneList().addTask("Task6");
        //then
        Assert.assertEquals(1, board.getToDoList().getTasks().size());
        Assert.assertEquals(2, board.getInProgressList().getTasks().size());
        Assert.assertEquals(3, board.getDoneList().getTasks().size());
    }
}
