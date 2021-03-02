package com.example.squareviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author: SuTs
 * @created at: 2021/3/2 14:37
 * @Describe:标题栏View
 */
public class TitleBarView extends RelativeLayout {
    private OnBtClickListener onBtClickListener;

    public TitleBarView(Context context) {
        super(context);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBarView);
        String leftBtContent = typedArray.getString(R.styleable.TitleBarView_leftBtContent);
        Drawable leftBtBg = typedArray.getDrawable(R.styleable.TitleBarView_leftBtBg);
        int leftBtColor = typedArray.getColor(R.styleable.TitleBarView_leftBtColor, 0);

        String rightBtContent = typedArray.getString(R.styleable.TitleBarView_rightBtContent);
        Drawable rightBtBg = typedArray.getDrawable(R.styleable.TitleBarView_rightBtBg);
        int rightBtColor = typedArray.getColor(R.styleable.TitleBarView_rightBtColor, 0);

        String tvTitleContent = typedArray.getString(R.styleable.TitleBarView_titleContent);
        float tvTitleSize = typedArray.getDimension(R.styleable.TitleBarView_titleTestSize, 0);
        int tvTitleColor = typedArray.getColor(R.styleable.TitleBarView_titleTestColor, 0);

        typedArray.recycle();
        //---
        Button leftButton = new Button(context);
        Button rightButton = new Button(context);
        TextView tvTitle = new TextView(context);

        leftButton.setText(leftBtContent);
        leftButton.setBackground(leftBtBg);
        leftButton.setTextColor(leftBtColor);

        rightButton.setText(rightBtContent);
        rightButton.setBackground(rightBtBg);
        rightButton.setTextColor(rightBtColor);

        tvTitle.setText(tvTitleContent);
        tvTitle.setTextSize(tvTitleSize);
        tvTitle.setTextColor(tvTitleColor);
        tvTitle.setGravity(Gravity.CENTER);

        setBackgroundColor(0xff346712);
//---
        LayoutParams leftBtLP = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftBtLP.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftButton, leftBtLP);

        LayoutParams rightBtLP = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightBtLP.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, rightBtLP);

        LayoutParams titleLP = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleLP.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(tvTitle, titleLP);
        //---
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBtClickListener != null) {
                    onBtClickListener.onLeftClick();
                }
                Toast.makeText(getContext(),"Left button",Toast.LENGTH_SHORT).show();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBtClickListener != null) {
                    onBtClickListener.onRightClick();
                }
                Toast.makeText(getContext(),"Right button",Toast.LENGTH_SHORT).show();
            }
        });
    }

    interface OnBtClickListener {
        void onLeftClick();

        void onRightClick();
    }

    public void setOnBtClickListener(OnBtClickListener onBtClickListener) {
        this.onBtClickListener = onBtClickListener;
    }
}
