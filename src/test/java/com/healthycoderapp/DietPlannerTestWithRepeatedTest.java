package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: 7
class DietPlannerTestWithRepeatedTest {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        String old = System.getProperty("count");
        if(old == null) {
            old = "1";
        }
        System.setProperty("count", String.valueOf(Integer.parseInt(old) + 1));
        System.out.println("finished a unit test" + " " + System.getProperty("count") );
    }
//todo: only used when any random numbers inside the method or change the state, involves multiple threads
    @RepeatedTest(10)
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