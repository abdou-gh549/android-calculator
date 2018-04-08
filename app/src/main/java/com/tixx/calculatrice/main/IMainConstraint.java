package com.tixx.calculatrice.main;

import android.widget.TextView;

/**
 * Created by abdellah on 4/2/2018.
 */

public interface IMainConstraint {
    interface IMainPresenter {

        void toggleAdvanceOperatorButton(int currentImageId);

        void saveExpression();
    }

    interface IMainView {
        void showAdvanceOperatorButton();

        void hideAdvanceOperatorButton();

        void clearResult();

        void clearInput();

        void addToInput(String inp);

        void doBackSpace();
        String getResult();
        void showResult(String result);
        TextView getNewTextView();

        String getInput();

    }
}
