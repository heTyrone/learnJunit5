package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

//    todo: 8
class BMICalculatorTestWithPerformanceTest {
    @Test
    public void should_ReturnCoderWithWorstBMICoder_When_CoderListHas10000Elements() throws InterruptedException {
        //given
        List<Coder> coderList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            coderList.add(new Coder(1.0 + i, 10.0 + i));
        }
        Thread.sleep(100L);
        //when
        //then
        assertTimeout(Duration.ofMillis(5), () -> BMICalculator.findCoderWithWorstBMI(coderList));
    }
//    todo: execution exceeded timeout of 1 ms by 7 ms
//    question: why in the left the whole test costs 25ms and the info indicates only use 7ms?
}


