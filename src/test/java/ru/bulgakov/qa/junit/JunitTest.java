package ru.bulgakov.qa.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class JunitTest
{

    enum Color {RED, GREEN, Blue}
    @ParameterizedTest
    @Disabled
    //@ValueSource(strings = {"Vlad", "Masha", "Donald Trump"})
    @EnumSource(Color.class)
    void paramTest(Color color){
        System.out.println(color.name());
    }
}


//@Nested
//    //@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//    public class PositiveTests{
//
//        //@RepeatedTest(2)
//        @Test
//        @Tag("positive")
//        @DisplayName("Это тест для теста 1")
//        @EnabledIfEnvironmentVariable(named = "env", matches ="dev")
//        //@DisabledOnOs(OS.WINDOWS)
//        @DisabledOnOs(OS.MAC)
//        //@Order(3)
//        //@Timeout(2)
//        //@Disabled("Bug number xyz")
//        void Test1()
//        {
//            //sleep(3000);
//            System.out.println("test 1");
//
////            assertAll(
////                    ()-> assertTrue (1<2),
////            ()-> assertFalse (1>2),
////            ()-> assertEquals(1, 1),
////            ()-> assertNotEquals(1, 2),
////            );
//        }
//
//        @Test
//        //@Order(2)
//        void Test2()
//        {
//            System.out.println("test 2");
//        }
//
//        @Test
//        //@Order(1)
//        void Test3()
//        {
//            System.out.println("test 3");
//        }
//    }
//
//    @Nested
//    public class NegativeTests{
//        @Test
//            //@Disabled("Bug number xyz")
//        void Test1()
//        {
//            System.out.println("test -1");
//        }
//
//        @Test
//        void Test2()
//        {
//            System.out.println("test -2");
//        }
//    }