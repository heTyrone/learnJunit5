package com.healthycoderapp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//todo: 4
class BMICalculatorTestWithArrayTest {
    @Test
    public void should_listOfBMIScores_When_CoderListNotEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));
        double[] expectedScores = {18.52, 29.59, 19.53};
        //when
        double[] BMIScores = BMICalculator.getBMIScores(coderList);
        //then
        assertArrayEquals(expectedScores, BMIScores);
    }
}


