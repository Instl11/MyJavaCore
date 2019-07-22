package training.Testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathJUnit4Test {



    @Before
    public void setUp()  {
    }

    @After
    public void tearDown() {
    }

    @Test()
    public void add() throws InterruptedException {
        int a = 2;
        int b = 3;
        int expResult = 5;
        int result = MyMath.add(a, b);
        assertEquals(expResult, result);
    }

    @Test(expected = ArithmeticException.class)
    public void dev() {
        int a = 8;
        int b = 0;
        int expResult = 4;
        int result = MyMath.dev(a, b);
        assertEquals(expResult, result);
    }
}