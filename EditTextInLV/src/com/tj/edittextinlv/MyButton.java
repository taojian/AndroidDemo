/*
 * @Title MyButton.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author taojian
 * @date 2016-12-30 ÉÏÎç9:32:32
 * @version 1.0
 */
package com.tj.edittextinlv;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Àà×¢ÊÍ
 * 
 * @author taojian
 * @date 2016-12-30 ÉÏÎç9:32:32
 */
public class MyButton extends Button implements OnClickListener{

	/**
	 * @param context
	 */
	public MyButton(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public MyButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public MyButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		if (attrs != null) {
			TypedArray array = getContext().obtainStyledAttributes(attrs,
					R.styleable.TestCustomView, 0, 0);
			int textSize = array.getInteger(
					R.styleable.TestCustomView_textSize, 10);
			array.recycle();
			setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
		}
	}

	/**
	 * @see android.view.View#dispatchTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d("TJ", "---MyButton---dispatchTouchEvent-----");
		return super.dispatchTouchEvent(event);
	}

	/**
	 * @see android.widget.TextView#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d("TJ", "---MyButton---onTouchEvent-----");
		return super.onTouchEvent(event);
		// return true;
	}

	/**
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("TJ", "---MyButton---onClick-----");
	}

}
