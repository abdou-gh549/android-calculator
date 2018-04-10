package com.tixx.calculatrice.advanceOperator;

import com.tixx.calculatrice.main.IMainConstraint.IMainView;


public class AdvanceOperatorPresenter implements IAdvanceOperatorPresenter {
    private IMainView mainView;
    private AdvanceOperatorModel advanceOperatorModel;

    public AdvanceOperatorPresenter(IMainView IMainView) {
        this.mainView = IMainView;
        advanceOperatorModel = new AdvanceOperatorModel();
    }

    @Override
    public void addCloseParenthes() {
        mainView.addToInput(")");
    }

    @Override
    public void addOpenParenthes() {
        mainView.addToInput("(");
    }

    @Override
    public void addPowerOperator() {
        String inputToAdd = advanceOperatorModel.addPowerOperator(mainView.getInput());
        mainView.addToInput(inputToAdd);
    }

    @Override
    public void addPi() {
        mainView.addToInput("π");
    }

    @Override
    public void addOtherOperator(String operator) {
        String operatorToAdd = advanceOperatorModel.addOperator(mainView.getInput(), operator);
        mainView.addToInput(operatorToAdd);
    }
}
