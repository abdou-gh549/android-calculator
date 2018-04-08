package com.tixx.calculatrice.main;

/**
 * Created by abdellah on 4/2/2018.
 */

public interface IMainConstraint {
    interface IMainPresenter {

        void toggleAdvanceOperatorButton(int currentImageId);
    }

    interface IMainView {
        void showAdvanceOperatorButton();

        void hideAdvanceOperatorButton();

        void clearResult();

        void clearInput();

        void addToInput(String inp);

        void doBackSpace();

        void showResult(String result);

        String getInput();

    }
}
