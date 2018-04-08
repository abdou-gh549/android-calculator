package com.tixx.calculatrice.basicCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorModelTest {

    BasicCalculatorModel basicCalcModel;

    @Before
    public void init(){
        basicCalcModel = new BasicCalculatorModel();
    }

    @Test
    public void validateNewInput() throws Exception {

        assertEquals("0", basicCalcModel.validateNewNumberInput("564", 0));
        assertEquals("0", basicCalcModel.validateNewNumberInput("", 0));
        assertEquals("", basicCalcModel.validateNewNumberInput("0", 0));
        assertEquals("5", basicCalcModel.validateNewNumberInput("10", 5));
        assertEquals("9", basicCalcModel.validateNewNumberInput("0", 9));
        assertEquals("7", basicCalcModel.validateNewNumberInput("9", 7));
    }
    @Test
    public void validateNewBasicOperatorInput() throws Exception {

        assertEquals("+", basicCalcModel.validateNewBasicOperatorInput("564", "+"));
        assertEquals("%", basicCalcModel.validateNewBasicOperatorInput("564", "%"));
        assertEquals("-", basicCalcModel.validateNewBasicOperatorInput("s", "-"));
        assertEquals("-", basicCalcModel.validateNewBasicOperatorInput("", "-"));
        assertEquals("-", basicCalcModel.validateNewBasicOperatorInput(")", "-"));
        assertEquals("", basicCalcModel.validateNewBasicOperatorInput("-", "-"));
        assertEquals("", basicCalcModel.validateNewBasicOperatorInput("(", "*"));
        assertEquals("", basicCalcModel.validateNewBasicOperatorInput("", "/"));
        assertEquals("", basicCalcModel.validateNewBasicOperatorInput("", "+"));
        assertEquals("+", basicCalcModel.validateNewBasicOperatorInput(")", "+"));
    }
    @Test
    public void validateNewPointInput() throws Exception {

        assertEquals(".", basicCalcModel.validateNewPointInput("564"));
        assertEquals("0.", basicCalcModel.validateNewPointInput(""));
        assertEquals("", basicCalcModel.validateNewPointInput("(545)"));
        assertEquals("", basicCalcModel.validateNewPointInput("(545)+8.2+5."));
        assertEquals(".", basicCalcModel.validateNewPointInput("(545)+8.2+5"));
        assertEquals(".", basicCalcModel.validateNewPointInput("(545)+8412*01"));
        assertEquals("", basicCalcModel.validateNewPointInput("(545)+8412*"));
    }



}