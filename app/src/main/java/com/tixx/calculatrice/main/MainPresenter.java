package com.tixx.calculatrice.main;

import com.tixx.calculatrice.R;


public class MainPresenter implements IMainConstraint.IMainPresenter {
    private IMainConstraint.IMainView IMainView;

    public MainPresenter(IMainConstraint.IMainView IMainView) {
        this.IMainView = IMainView;
    }

    @Override
    public void toggleAdvanceOperatorButton(int currentImageId) {
        if (currentImageId == R.drawable.ic_down) {
            IMainView.hideAdvanceOperatorButton();
        } else IMainView.showAdvanceOperatorButton();
    }
}
