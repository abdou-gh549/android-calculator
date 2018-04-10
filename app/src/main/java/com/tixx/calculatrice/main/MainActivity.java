package com.tixx.calculatrice.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.tixx.calculatrice.R;
import com.tixx.calculatrice.advanceOperator.AdvanceOperatorFragment;
import com.tixx.calculatrice.basicCalculator.BasicCalculatorFragment;


public class MainActivity extends AppCompatActivity implements IMainConstraint.IMainView {

    private ImageButton upDownImageButton;
    private View advanceButtonFragment;
    private TextView inputTextView;
    private TextView resultTextView;

    private boolean clearResult = false;

    private MainPresenter mainPresenter;

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density) / 2);
        v.startAnimation(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upDownImageButton = findViewById(R.id.up_down_Button);
        advanceButtonFragment = findViewById(R.id.advanceButtonFragment);
        inputTextView = findViewById(R.id.inputTextView);
        resultTextView = findViewById(R.id.resultTextView);

        mainPresenter = new MainPresenter(this);

        //pass the Main view to fragment
        ((BasicCalculatorFragment) getFragmentManager().findFragmentById(R.id.basicButtonFragment)).setMainView(this);
        ((AdvanceOperatorFragment) getFragmentManager().findFragmentById(R.id.advanceButtonFragment)).setMainView(this);

        advanceButtonFragment.setVisibility(View.INVISIBLE);
        upDownImageButton.setTag(R.drawable.ic_up);
    }

    @Override
    public void showAdvanceOperatorButton() {
        expand(advanceButtonFragment);
        upDownImageButton.setTag(R.drawable.ic_down);
        upDownImageButton.setImageResource(R.drawable.ic_down);
    }

    @Override
    public void hideAdvanceOperatorButton() {

        collapse(advanceButtonFragment);
        upDownImageButton.setTag(R.drawable.ic_up);
        upDownImageButton.setImageResource(R.drawable.ic_up);
    }

    @Override
    public void clearResult() {
        mainPresenter.saveExpression();
        resultTextView.setText("");
    }

    @Override
    public void clearInput() {
        clearResult();
        inputTextView.setText("");
    }

    @Override
    public String getInput() {
        return inputTextView.getText().toString();
    }

    @Override
    public void addToInput(String inp) {
        if (clearResult) {
            clearResult();
            clearResult = false;
        }
        inputTextView.append(inp);
    }

    @Override
    public void doBackSpace() {
        String inp = getInput();
        // delete last char from inp
        String newInp = inp.substring(0, inp.length() - 1);

        inputTextView.setText(newInp);
    }

    @Override
    public void showResult(String result) {
        clearResult = true;
        Log.d("result", result);
        resultTextView.setText(result);
    }


    public void expand(final View v) {
        v.measure(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? WindowManager.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density) / 2);
        v.startAnimation(a);
    }

    public void onUpDownButtonCLick(View view) {
        mainPresenter.toggleAdvanceOperatorButton((Integer) upDownImageButton.getTag());
    }
}
