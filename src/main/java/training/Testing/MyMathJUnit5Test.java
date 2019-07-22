package training.Testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathJUnit5Test {




    public MyMathJUnit5Test() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> {
            int a = 2;
            int b = 3;
            int expResult = 5;
            int result = MyMath.add(a, b);
            assertEquals(expResult, result);
        });
    }

    @Test
    void dev() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int a = 8;
            int b = 0;
            int expResult = 4;
            int result = MyMath.dev(a, b);
            assertEquals(expResult, result);
        });
    }
}