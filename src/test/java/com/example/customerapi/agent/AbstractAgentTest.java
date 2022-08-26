package com.example.customerapi.agent;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AbstractAgentTest {

    private AbstractAgent agent;

    @BeforeAll
    void init() {
        this.agent = new TestAgent();
    }

    @Test
    @Order(2)
    void testName() {
        System.out.println("2");
        assertEquals("TestAgent", this.agent.getName());
    }

    @Test
    @Order(1)
    void fail() {
        System.out.println("1");
        assertThrows(IllegalStateException.class, TestAgent2::new);
    }
}