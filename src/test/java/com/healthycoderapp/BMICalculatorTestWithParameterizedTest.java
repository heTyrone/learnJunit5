package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
//todo: 6
class BMICalculatorTestWithParameterizedTest {

    //todo: one variables test
    @ParameterizedTest
    @ValueSource(doubles = {79.0, 89.0, 95.0, 110.0})
    void should_returnTrue_when_DietRecommendedOneVariable(Double valueAutoInjected) {
//        given
        double weight = valueAutoInjected;
        double height = 1.72;
//        when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
//        then
        assertTrue(recommended);
    }

    @ParameterizedTest
    @CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"})
    void should_returnTrue_when_DietRecommendedTwoVariables(Double coderWight, Double coderHeight) {
//        given
        double weight = coderWight;
        double height = coderHeight;
//        when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
//        then
        assertTrue(recommended);
    }
//    todo: test log shown
//            [1] 89.0, 1.72
//            [2] 95.0, 1.75
//            [3] 110.0, 1.78

    @ParameterizedTest(name = "weight = {0}, height = {1}")
    @CsvSource(value = {"89.0, 1.72, 12.3", "95.0, 1.75", "110.0, 1.78"})
    void should_returnTrue_when_DietRecommendedTwoVariablesAndName(Double sss, Double bbb, Double ccc) {
//        given
        double weight = sss;
        double height = bbb;
        double xxx = ccc;
//        when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
//        then
        assertTrue(recommended);
    }
//    todo: test log shown
//    weight = 89.0, height = 1.72
//    weight = 95.0, height = 1.75
//    weight = 110.0, height = 1.78

//    todo:
    @ParameterizedTest(name = "weight = {0}, height = {1}")
//    automatically looking for files in /test/resources
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1, lineSeparator = "@")
    void should_returnTrue_when_DietRecommendedWithCSVFile(Double coderWight, Double coderHeight) {
//        given
        double weight = coderWight;
        double height = coderHeight;
//        when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
//        then
        assertTrue(recommended);
    }
//    todo: test log shown
//    weight = 89.0, height = 1.72
//    weight = 95.0, height = 1.75
//    weight = 110.0, height = 1.78

}


