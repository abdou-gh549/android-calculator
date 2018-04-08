package com.tixx.calculatrice.advanceOperator;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tixx.calculatrice.R;
import com.tixx.calculatrice.main.IMainConstraint.IMainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AdvanceOperatorFragment extends Fragment {

    private View advanceOperatorView;
    private AdvanceOperatorPresenter m_presenter;
    private IMainView m_mainView;

    public AdvanceOperatorFragment() {
        // Required empty public constructor
    }


    public void setMainView(IMainView m_mainView) {
        this.m_mainView = m_mainView;
        m_presenter = new AdvanceOperatorPresenter(m_mainView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        advanceOperatorView = inflater.inflate(R.layout.fragment_advance_operator, container, false);

        setUpButtons();
        return advanceOperatorView;
    }

    private void setUpButtons() {
        setUpParenthes();
        setUpFunction();
        setUpOperator();
    }

    private void setUpOperator() {
        advanceOperatorView.findViewById(R.id.pow)
                .setOnClickListener(e-> m_presenter.addPowerOperator());
        advanceOperatorView.findViewById(R.id.pi)
                .setOnClickListener(e-> m_presenter.addPi());
    }

    private void setUpParenthes() {
        advanceOperatorView.findViewById(R.id.openParenthese)
                .setOnClickListener(e-> m_presenter.addOpenParenthes());
        advanceOperatorView.findViewById(R.id.closeParenthese)
                .setOnClickListener(e-> m_presenter.addCloseParenthes());
    }

    private void setUpFunction() {
        ArrayList<String> operators = new ArrayList<>();
        operators.add("cos");
        operators.add("sin");
        operators.add("tan");
        operators.add("exp");
        operators.add("log");
        operators.add("ln");
        operators.add("sqrt");
        operators.add("fact");

        Map<String, Integer> buttons = new HashMap<>();
        buttons.put( "cos", R.id.cos);
        buttons.put( "sin", R.id.sin);
        buttons.put( "tan", R.id.tan);
        buttons.put( "exp", R.id.exp);
        buttons.put( "log", R.id.log);
        buttons.put( "ln", R.id.ln);
        buttons.put( "sqrt", R.id.sqrt);
        buttons.put( "fact", R.id.fact);
        for (int i= 0; i<operators.size(); i++){
            Button btn = advanceOperatorView.findViewById(buttons.get(operators.get(i)));
            btn.setTag(operators.get(i));
            btn.setOnClickListener(e->m_presenter.addOtherOperator(btn.getTag().toString()));
        }


    }


}
