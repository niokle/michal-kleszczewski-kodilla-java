package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculationsAdd() {
        //given
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        //when
        int a = 10;
        int b = 5;
        //then
        Assert.assertEquals(15, calculator.add(a, b), 0);
    }

    @Test
    public void testCalculationsSub() {
        //given
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        //when
        int a = 10;
        int b = 5;
        //then
        Assert.assertEquals(5, calculator.sub(a, b), 0);
    }

    @Test
    public void testCalculationsMul() {
        //given
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        //when
        int a = 10;
        int b = 5;
        //then
        Assert.assertEquals(50, calculator.mul(a, b), 0);
    }

    @Test
    public void testCalculationsDiv() {
        //given
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        //when
        int a = 10;
        int b = 5;
        //then
        Assert.assertEquals(2, calculator.div(a, b), 0);
    }
}
