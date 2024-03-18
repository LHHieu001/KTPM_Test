/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.hieuhoang.services;

import java.time.Duration;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author lehoa
 */
public class TestNguyenToTest {
    
//   @BeforeAll
//    public static void beforeAll(){
//        System.out.println("BeforeAll");
//    }
//    
//    @AfterAll
//    public static void afterAll(){
//        System.out.println("After All");
//    }
    
    @Test
    public void testOddNumber(){
        boolean actual = TestNguyenTo.isNguyenTo(5);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testEvenNumber(){
        boolean actual = TestNguyenTo.isNguyenTo(3);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testException(){
        ArithmeticException assertThrow = Assertions.assertThrows(ArithmeticException.class, ()->{
            TestNguyenTo.isNguyenTo(-1);
        });
//        ArithmeticException assertThrows = Assertions.assertThrows(ArithmeticException.class, ()->{
//            TestNguyenTo.isNguyenTo(-5);
//        });
    }
    
    @Test
    public void testTimeOut(){
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds (1), ()->{
            TestNguyenTo.isNguyenTo(7);
        });
    }   
    
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13})
    public void testOddNumber1(int n){
        boolean actual = TestNguyenTo.isNguyenTo(n);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    
    @ParameterizedTest
    @CsvSource({"2, true", "4, false"})
    public void testOddNumber2(int n, boolean expected){
        Assertions.assertEquals(TestNguyenTo.isNguyenTo(n),expected);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/database.csv", numLinesToSkip = 1) 
    public void testOddNumber3(int n, boolean expected){
        Assertions.assertEquals(TestNguyenTo.isNguyenTo(n),expected);
    }
    
    static Stream<Arguments> dataTest(){
        return Stream.of(
                arguments(4, false),
                arguments(6, false)
        );
    }
    
    @ParameterizedTest
    @MethodSource (value = "dataTest")
    public void testOddNumber4(int n, boolean expected){
        Assertions.assertEquals(TestNguyenTo.isNguyenTo(n),expected);
    }
//    @Test
//    public void test1() {
//        System.out.println("Test case 01");
//    }
//
//    @Test
//    public void test2() {
//        System.out.println("Test case 02");
//    }
    
}
