package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

//todo: 1
class BMICalculatorTest {

    //    todo: test naming convention should return when
    @Test
    void should_returnTrue_when_DietRecommended() {
        assertTrue(BMICalculator.isDietRecommended(89.0, 1.72));
    }

    //todo: given when then
//    betterWayToImplement
    @Test
    void should_returnTrue_when_DietRecommended2() {
//        given
        double weight = 89.0;
        double height = 1.72;
//        when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
//        then
        assertTrue(recommended);
    }

    //    todo: test exception thrown
    @Test
    void should_Throw_exception_when_0Height() {
        //        given
        double weight = 50.0;
        double height = 0.0;
//        when
//        boolean recommended = BMICalculator.isDietRecommended(weight,height);
        //        then
        assertThrows(ArithmeticException.class, () -> BMICalculator.isDietRecommended(weight, height));
    }
}


