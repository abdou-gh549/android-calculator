package com.tixx.calculatrice.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.tixx.calculatrice.R;



public class MainPresenter implements IMainConstraint.IMainPresenter {
    private IMainConstraint.IMainView mainView;

    public MainPresenter(IMainConstraint.IMainView IMainView) {
        this.mainView = IMainView;
    }

    @Override
    public void toggleAdvanceOperatorButton(int currentImageId) {
        if (currentImageId == R.drawable.ic_down) {
            mainView.hideAdvanceOperatorButton();
        } else mainView.showAdvanceOperatorButton();
    }

    @Override
    public void saveExpression() {
//        String input = mainView.getInput() + " = ";
//        String result = mainView.getResult();
//        TextView textView = mainView.getNewTextView();
//        textView.setText(input+result);
    }


}
