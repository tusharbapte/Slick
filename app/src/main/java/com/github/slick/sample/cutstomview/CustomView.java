package com.github.slick.sample.cutstomview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.slick.Presenter;
import com.github.slick.Slick;
import com.github.slick.sample.R;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2017-03-09
 */

public class CustomView extends LinearLayout implements ExampleView {

    @Presenter
    ViewPresenter presenter;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Slick.bind(this);
        Slick.onAttach(this);

        final TextView textView = (TextView) findViewById(R.id.textView_custom_view);
        textView.setText(presenter.getData());
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Slick.onDetach(this);
    }
}
