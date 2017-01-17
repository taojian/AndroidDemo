/*
 * @Title CustomViewGroup.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author taojian
 * @date 2016-12-29 ÏÂÎç5:31:58
 * @version 1.0
 */
package com.tj.edittextinlv;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Àà×¢ÊÍ
 * 
 * @author taojian
 * @date 2016-12-29 ÏÂÎç5:31:58
 */
public class CustomLayout extends FrameLayout {

	/**
	 * @param context
	 */
	public CustomLayout(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public CustomLayout(Context context, AttributeSet attrs) {
		this(context, null, 0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public CustomLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		Log.d("TJ", "---CustomLayout---dispatchTouchEvent-----");
//		return super.dispatchTouchEvent(ev);
		return false;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		Log.d("TJ", "---CustomLayout---onInterceptTouchEvent-----");
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d("TJ", "---CustomLayout---onTouchEvent-----");
		return super.onTouchEvent(event);
	}

}
