package com.tixx.calculatrice.basicCalculator;

/**
 * Created by abdellah on 4/4/2018.
 */

public interface IBasicCalculatorPresenter {
    boolean clearInput = false;
    void numberButtonClick(int buttonTage);
    void operatorButtonClick(String operator);
    void backSpace();
    void addPoint();
    void calculResult();
}
