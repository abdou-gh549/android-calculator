package com.tixx.calculatrice.basicCalculator;

import android.util.Log;

import com.tixx.calculatrice.main.IMainConstraint.IMainView;
import com.tixx.calculatrice.util.ArithmeticEvaluator;


public class BasicCalculatorPresenter implements IBasicCalculatorPresenter {
    private IMainView mainView;
    private BasicCalculatorModel m_basicCalcModel;

    public BasicCalculatorPresenter(IMainView IMainView) {
        this.mainView = IMainView;
        m_basicCalcModel = new BasicCalculatorModel();
    }

    @Override
    public void numberButtonClick(int buttonTage) {

        String inp = mainView.getInput();
        String inputToAdd = m_basicCalcModel.validateNewNumberInput(inp, buttonTage);
        if ("0".equals(inp)) {
            mainView.clearInput();
        }
        mainView.addToInput(inputToAdd);
    }

    @Override
    public void operatorButtonClick(String operator) {
        String inputToAdd = m_basicCalcModel.validateNewBasicOperatorInput(mainView.getInput(), operator);
        mainView.addToInput(inputToAdd);
    }

    @Override
    public void backSpace() {
        String input = mainView.getInput();
        int backStep = m_basicCalcModel.backSpace(input);
        for (int i = 0; i < backStep; i++) {
            mainView.doBackSpace();
        }
    }

    @Override
    public void addPoint() {
        String inputToAdd = m_basicCalcModel.validateNewPointInput(mainView.getInput());
        mainView.addToInput(inputToAdd);
    }

    @Override
    public void calculResult() {
        String inp = mainView.getInput();
        try {
            ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
            Double result = arithmeticEvaluator.evaluate(inp);
            mainView.showResult(result.toString());
        } catch (RuntimeException exp) {
            mainView.showResult(exp.getMessage());
        }

    }
}
