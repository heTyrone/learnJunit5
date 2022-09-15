package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//todo: 5
class DietPlannerTestBeforeEach {

//    todo: beforeEach After each

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
//    todo: explain @beforeAll @afterAll, the difference between @beforeClass @afterClass
}