package com.kodilla.spring.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DisplayTestSuite {

    @Mock
    private Display display;

    @InjectMocks
    private final Calculator calculator = new Calculator();

    @Test
    public void testDisplay() {
        double sum = calculator.add(5, 5);
        verify(display, times(1)).displayValue(sum);
    }
}
