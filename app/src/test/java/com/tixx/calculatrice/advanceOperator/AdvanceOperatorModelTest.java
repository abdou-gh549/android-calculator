package com.tixx.calculatrice.advanceOperator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdvanceOperatorModelTest {
    AdvanceOperatorModel advanceOperatorModel;

    @Before
    public void setUp() throws Exception {
        advanceOperatorModel = new AdvanceOperatorModel();
    }

    @Test
    public void addPowerOperator() throws Exception {
        assertEquals("^", advanceOperatorModel.addPowerOperator("564"));
        assertEquals("", advanceOperatorModel.addPowerOperator("564^"));
        assertEquals("", advanceOperatorModel.addPowerOperator(""));
        assertEquals("", advanceOperatorModel.addPowerOperator("5+5+"));
        assertEquals("^", advanceOperatorModel.addPowerOperator("5+3)"));
    }
    @Test
    public void addOperator() throws Exception {
        assertEquals("", advanceOperatorModel.addOperator("564", "cos"));
        assertEquals("cos(", advanceOperatorModel.addOperator("^", "cos"));
        assertEquals("", advanceOperatorModel.addOperator("564)", "cos"));
    }

}