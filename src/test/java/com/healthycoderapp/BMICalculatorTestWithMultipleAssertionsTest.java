package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//todo: 2
class BMICalculatorTestWithMultipleAssertionsTest {

    //todo: test with multiple assertions
    @Test
    public void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
        //given
        List<Coder> coderList = Arrays.asList(new Coder(1.80, 60.0), new Coder(1.82, 98.0), new Coder(1.82, 64.7));
//        coderList.add(new Coder(1.80, 60.0));
//        coderList.add(new Coder(1.82, 98.0));
//        coderList.add(new Coder(1.82, 64.7));
        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        //then
        assertEquals(1.82, coderWorstBMI.getHeight());
        assertEquals(98.0, coderWorstBMI.getWeight());
    }

    //    todo: if we make both of it fail, only the first one give us error
    @Test
    public void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty2() {
        //given
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));
        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        //then
        assertEquals(1.85, coderWorstBMI.getHeight());
        assertEquals(98.2, coderWorstBMI.getWeight());
    }

    //    todo: improve the pain point
    @Test
    public void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty_Improved() {
        //given
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));
        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        //then
        assertAll(
                () -> assertEquals(1.85, coderWorstBMI.getHeight()),
                () -> assertEquals(98.7, coderWorstBMI.getWeight())
        );

    }
}


