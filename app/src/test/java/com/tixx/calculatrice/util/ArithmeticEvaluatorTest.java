package com.tixx.calculatrice.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticEvaluatorTest {
    ArithmeticEvaluator ar;

    @Before
    public void init() {
        ar = new ArithmeticEvaluator();
    }

    @Test
    public void evaluat() {
        assertEquals(9999999. * 999999999, ar.evaluate("9999999*999999999"), 0);
        assertEquals(10, ar.evaluate("5+5"), 0);
    }

}