package com.afaqy.service.junit;

import org.junit.jupiter.api.*;

class StandardTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("----- beforeAll -----");
    }

    @BeforeEach
    void setUp() {
        System.out.println("----- setUp -----");
    }

    @Test
    void succeedingTest() {
        Assertions.assertTrue(true);
    }

    @Test
    void failingTest() {
        //        Assertions.fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
        System.out.println("----- tearDown -----");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("----- afterAll -----");
    }

}
