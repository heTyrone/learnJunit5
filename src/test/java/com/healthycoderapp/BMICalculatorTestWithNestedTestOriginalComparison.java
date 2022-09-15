package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//todo: 9
class BMICalculatorTestWithNestedTestOriginalComparison {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        System.out.println("finished a unit test");
    }

    @Test
    void should_returnTrue_when_DietRecommended() {
        assertTrue(BMICalculator.isDietRecommended(89.0, 1.72));
    }

    @Test
    void should_returnTrue_when_DietRecommended2() {
//        given
            double weight = 89.0;
            double height = 1.72;
//        when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);
//        then
        assertTrue(recommended);
    }
    

    @Test
    void should_Throw_exception_when_0Height() {
        //        given
        double weight = 50.0;
        double height = 0.0;
//        when
//        boolean recommended = BMICalculator.isDietRecommended(weight,height);
        Executable executable = () -> BMICalculator.isDietRecommended(weight,height);
//        then
        assertThrows(ArithmeticException.class, executable);
    }


    @Test
    public void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));
        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        //then
        assertEquals(1.82, coderWorstBMI.getHeight());
        assertEquals(98.0, coderWorstBMI.getWeight());
    }

    @Test
    public void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        //given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);
        //when
        DietPlan actual = dietPlanner.calculateDiet(coder);
        //then
        assertAll(
                ()->assertEquals(expectedDietPlan.getCalories(), actual.getCalories()),
                ()->assertEquals(expectedDietPlan.getCarbohydrate(), actual.getCarbohydrate()),
                ()->assertEquals(expectedDietPlan.getFat(), actual.getFat()),
                ()->assertEquals(expectedDietPlan.getProtein(), actual.getProtein())
        );
    }
}


