package com.healthycoderapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//todo: 10
class BMICalculatorTestWithNestedTest {

    @Nested
    class isDietRecommendedTest {
        @Test
        void should_returnTrue_when_DietRecommended() {
            assertTrue(BMICalculator.isDietRecommended(89.0, 1.72));
        }

        @Test
        void should_returnTrue_when_DietRecommended2() {
            double weight = 89.0;
            double height = 1.72;
            boolean recommended = BMICalculator.isDietRecommended(weight, height);
            assertTrue(recommended);
        }

        @Test
//        todo: 11
//        @Disabled
//        @DisplayName("sdasdasdasd")
        @DisabledOnOs(OS)
        void should_Throw_exception_when_0Height() {
            double weight = 50.0;
            double height = 0.0;
            Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
            assertThrows(ArithmeticException.class, executable);
        }

    }

    @Nested
    class findWorstBMICoderTest {
        @Test
        public void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
            List<Coder> coderList = new ArrayList<>();
            coderList.add(new Coder(1.80, 60.0));
            coderList.add(new Coder(1.82, 98.0));
            coderList.add(new Coder(1.82, 64.7));
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
            assertEquals(1.82, coderWorstBMI.getHeight());
            assertEquals(98.0, coderWorstBMI.getWeight());
        }
    }

    @Nested
    class calculateDietTest {
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
                    () -> assertEquals(expectedDietPlan.getCalories(), actual.getCalories()),
                    () -> assertEquals(expectedDietPlan.getCarbohydrate(), actual.getCarbohydrate()),
                    () -> assertEquals(expectedDietPlan.getFat(), actual.getFat()),
                    () -> assertEquals(expectedDietPlan.getProtein(), actual.getProtein())
            );
        }
    }

}




