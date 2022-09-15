package com.healthycoderapp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
// todo: 3
class BMICalculatorTestWithNullReturnTest {
    @Test
    public void should_ReturnNullWorstBMICoder_When_CoderListIsEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>();
        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        //then
        assertNull(coderWorstBMI);
    }
}


