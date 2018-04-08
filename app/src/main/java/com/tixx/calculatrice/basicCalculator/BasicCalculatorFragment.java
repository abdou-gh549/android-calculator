package com.tixx.calculatrice.basicCalculator;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tixx.calculatrice.R;
import com.tixx.calculatrice.main.IMainConstraint.IMainView;

import java.util.HashMap;
import java.util.Map;

public class BasicCalculatorFragment extends Fragment {
    private static BasicCalculatorFragment m_basicCalculatorFragment;
    private static BasicCalculatorPresenter presenter;
    View basicCalculatorView;
    private IMainView m_mainView;

    public BasicCalculatorFragment() {

    }


    public void setMainView(IMainView m_mainView) {
        this.m_mainView = m_mainView;
        presenter = new BasicCalculatorPresenter(m_mainView);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        basicCalculatorView = inflater.inflate(R.layout.fragment_basic_calculator, container, false);

        setUpButtons();


        return basicCalculatorView;
    }

    private void setUpButtons() {
        setupNumberButton();
        setUpClearBtn();
        setUpOperatorButton();
        setUpPointButton();
        setUpEqualButton();
    }

    private void setUpPointButton() {
        basicCalculatorView.findViewById(R.id.button_point)
                .setOnClickListener(e->presenter.addPoint());
    }

    private void setUpClearBtn() {
        basicCalculatorView.findViewById(R.id.button_backspace)
                .setOnClickListener(e -> presenter.backSpace());

        basicCalculatorView.findViewById(R.id.button_Ac)
                .setOnClickListener(e -> m_mainView.clearInput());
    }

    private void setupNumberButton() {
        Button button;
        int buttonsId[] = new int[]{
                R.id.button_0, R.id.button_1, R.id.button_2,
                R.id.button_3, R.id.button_4, R.id.button_5,
                R.id.button_6, R.id.button_7, R.id.button_8,
                R.id.button_9};

        for (int i = 0; i < buttonsId.length; i++) {
            button = basicCalculatorView.findViewById(buttonsId[i]);
            button.setTag(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("click", "button number clicked");
                    presenter.numberButtonClick((Integer) view.getTag());
                }
            });
        }


    }

    private void setUpOperatorButton() {
        Button button;
        String operator = "+-*/%";
        Map<Character, Integer> buttons = new HashMap<>();
        buttons.put( '+', R.id.button_plus);
        buttons.put( '-', R.id.button_min);
        buttons.put( '*', R.id.button_mult);
        buttons.put( '/', R.id.button_div);
        buttons.put( '%', R.id.button_mod);


        for (int i = 0; i < buttons.size(); i++) {
            button = basicCalculatorView.findViewById(buttons.get( operator.charAt(i) ));
            button.setTag(operator.charAt(i));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("click", "button basic operator clicked");
                    presenter.operatorButtonClick(String.valueOf(view.getTag()));
                }
            });
        }
    }

    private void setUpEqualButton(){
        basicCalculatorView.findViewById(R.id.button_equal)
                .setOnClickListener(e->presenter.calculResult());
    }

}
