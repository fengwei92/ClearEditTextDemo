package com.fengw.cleareditlibrary;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class ClearEditText extends androidx.appcompat.widget.AppCompatEditText implements TextWatcher {
    private Drawable mClearDrawable;

    public ClearEditText(Context context) {
        this(context,null);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs,android.R.attr.editTextStyle);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mClearDrawable = getCompoundDrawables()[2];
        if (mClearDrawable == null){
            mClearDrawable = getResources().getDrawable(R.drawable.delete);
        }
        mClearDrawable.setBounds(0,
                0,
                mClearDrawable.getIntrinsicWidth(),
                mClearDrawable.getIntrinsicHeight());
        setClearIconVisible(false);
    }


    private void setClearIconVisible(boolean visible){
        Drawable right = visible ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0],
                getCompoundDrawables()[1],
                right,
                getCompoundDrawables()[3]);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        setClearIconVisible(s.length() > 0);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP){
            if (getCompoundDrawables()[2] != null){
                int x = (int) event.getX();
                int y = (int) event.getY();
                Rect rect = getCompoundDrawables()[2].getBounds();
                int height = rect.height();
                int distance = (getHeight() - height)/2;
                boolean isInnerWidth = x > (getWidth() - getTotalPaddingRight()) && x < (getWidth() - getPaddingRight());
                boolean isInnerHeight = y > distance && y < distance + height;
                if (isInnerWidth && isInnerHeight){
                    this.setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
