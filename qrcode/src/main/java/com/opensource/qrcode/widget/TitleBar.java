/*
 * Copyright (C) 2016. The Android Open Source Project.
 *
 *          yinglovezhuzhu@gmail.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.opensource.qrcode.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.opensource.qrcode.R;


/**
 * 标题（简单的标题栏，两边各有两个按钮，中间文字）
 * Created by yinglovezhuzhu@gmail.com on 2016/1/12.
 */
public class TitleBar extends LinearLayout {
	
	public static final int ID_LEFT_BUTTON = R.id.btn_titlebar_left;
	public static final int ID_LEFT_BUTTON2 = R.id.btn_titlebar_left2;
	public static final int ID_RIGHT_BUTTON = R.id.btn_titlebar_right;
	public static final int ID_RIGHT_BUTTON2 = R.id.btn_titlebar_right2;

    private Button mBtnLeft;
    private Button mBtnLeft2;
    private Button mBtnRight;
    private Button mBtnRight2;

    private TextView mTvTitle;

    public TitleBar(Context context) {
        super(context);

        initView(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

//    @TargetApi(21)
//    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        initView(context, attrs);
//    }

    /**
     * 设置标题背景
     * @param resId
     */
    public TitleBar setTitleBackGroundResource(int resId) {
        this.setBackgroundResource(resId);
        return this;
    }

    /**
     * 设置标题文字颜色
     * @param resId
     */
    public TitleBar setTitleTextColor(int resId) {
        ColorStateList textColor = getResourceColorStateList(resId);
        if(null != textColor) {
            mTvTitle.setTextColor(textColor);
        }
        return this;
    }

    /**
     * 设置标题文字
     * @param resId
     */
    public TitleBar setTitleText(int resId) {
        mTvTitle.setText(resId);
        return this;
    }

    /**
     * 设置标题文字
     * @param text
     */
    public TitleBar setTitleText(CharSequence text) {
        mTvTitle.setText(text);
        return this;
    }


    /**
     * 配置左按钮
     * @param iconResId 图标资源id
     * @param listener 点击监听
     * @return 当前标题栏对象
     */
    public TitleBar setLeftButton(int iconResId, OnClickListener listener) {
        setLeftButton(iconResId, 0);
        mBtnLeft.setOnClickListener(listener);
        return this;
    }


    /**
     * 配置左按钮2
     * @param iconResId 图标资源id
     * @param listener 点击监听
     * @return 当前标题栏对象
     */
    public TitleBar setLeftButton2(int iconResId, OnClickListener listener) {
        setLeftButton2(iconResId, 0);
        mBtnLeft2.setOnClickListener(listener);
        return this;
    }
    
    /**
     * 配置左按钮
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @param listener 点击监听
     * @return 当前标题栏对象
     */
    public TitleBar setLeftButtonWithText(int iconResId, int textResId, OnClickListener listener) {
    	setLeftButton(iconResId, textResId);
    	mBtnLeft.setOnClickListener(listener);
    	return this;
    }
    
    /**
     * 配置左按钮2
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @param listener 点击监听
     * @return 当前标题栏对象
     */
    public TitleBar setLeftButton2WithText(int iconResId, int textResId, OnClickListener listener) {
    	setLeftButton2(iconResId, textResId);
    	mBtnLeft2.setOnClickListener(listener);
    	return this;
    }

    /**
     * 启用/禁用左1按钮
     * @param enabled
     * @return
     */
    public TitleBar setLeftButtonEnabled(boolean enabled) {
        mBtnLeft.setEnabled(enabled);
        return this;
    }

    /**
     * 启用/禁用左2按钮
     * @param enabled
     * @return
     */
    public TitleBar setLeftButton2Enabled(boolean enabled) {
        mBtnLeft2.setEnabled(enabled);
        return this;
    }

    /**
     * 配置右按钮
     * @param iconResId 图标资源id
     * @param listener 点击监听
     * @return 当前标题栏对象
     */
    public TitleBar setRightButton(int iconResId, OnClickListener listener) {
        setRightButton(iconResId, 0);
        mBtnRight.setOnClickListener(listener);
        return this;
    }

    /**
     * 配置右按钮2
     * @param iconResId 图标资源id
     * @param listener 点击监听
     * @return 当前标题栏对象
     */
    public TitleBar setRightButton2(int iconResId, OnClickListener listener) {
        setRightButton2(iconResId, 0);
        mBtnRight2.setOnClickListener(listener);
        return this;
    }

    /**
     * 配置右按钮
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @return 当前标题栏对象
     */
    public TitleBar setRightButtonWithText(int iconResId, int textResId, OnClickListener listener) {
        setRightButton(iconResId, textResId);
        mBtnRight.setOnClickListener(listener);
        return this;
    }

    /**
     * 配置右按钮2
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @return 当前标题栏对象
     */
    public TitleBar setRightButton2WithText(int iconResId, int textResId, OnClickListener listener) {
        setRightButton2(iconResId, textResId);
        mBtnRight2.setOnClickListener(listener);
        return this;
    }

    public TitleBar setRightButtonTextColorResource(int resId) {
        mBtnRight.setTextColor(getResourceColor(resId));
        return this;
    }

    public TitleBar setRightButton2TextColorResource(int resId) {
        mBtnRight2.setTextColor(getResourceColor(resId));
        return this;
    }

    public TitleBar setRightButtonBackgroundResource(int resId) {
        mBtnRight.setBackgroundResource(resId);
        return this;
    }

    public TitleBar setRightButton2BackgroundResource(int resId) {
        mBtnRight2.setBackgroundResource(resId);
        return this;
    }

    /**
     * 启用/禁用右1按钮
     * @param enabled
     * @return
     */
    public TitleBar setRightButtonEnabled(boolean enabled) {
        mBtnRight.setEnabled(enabled);
        return this;
    }

    /**
     * 启用/禁用右1按钮
     * @param enabled
     * @return
     */
    public TitleBar setRightButton2Enabled(boolean enabled) {
        mBtnRight2.setEnabled(enabled);
        return this;
    }
    
    @SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
    protected ColorStateList getResourceColorStateList(int resId) {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return getResources().getColorStateList(resId);
        } else {
            try {
                return getResources().getColorStateList(resId, null);
            } catch (NoSuchMethodError e) {
                return getResources().getColorStateList(resId);
            }
        }
    }

    @SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
    protected int getResourceColor(int resId) {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return getResources().getColor(resId);
        } else {
            try {
                return getResources().getColor(resId, null);
            } catch (NoSuchMethodError e) {
                return getResources().getColor(resId);
            }
        }
    }

    @SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
    protected Drawable getResourceDrawable(int resId) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
            drawable = getResources().getDrawable(resId);
        } else {
            try {
                drawable = getResources().getDrawable(resId, null);
            } catch (NoSuchMethodError e) {
                drawable = getResources().getDrawable(resId);
            }
        }
        return drawable;
    }

    /**
     * 初始化UI
     * @param context
     * @param attrs
     */
    private void initView(Context context, AttributeSet attrs) {
        inflate(context, R.layout.layout_title_bar, this);

        mBtnLeft = (Button) findViewById(ID_LEFT_BUTTON);
        mBtnLeft2 = (Button) findViewById(ID_LEFT_BUTTON2);
        mBtnRight = (Button) findViewById(ID_RIGHT_BUTTON);
        mBtnRight2 = (Button) findViewById(ID_RIGHT_BUTTON2);
        mTvTitle = (TextView) findViewById(R.id.tv_titlebar_title);
    }

    /**
     * 配置左按钮
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @return 当前标题栏对象
     */
    private TitleBar setLeftButton(int iconResId, int textResId) {
        mBtnLeft.setText(0 == textResId ? "" : getResources().getText(textResId));
        mBtnLeft.setCompoundDrawablesWithIntrinsicBounds(iconResId, 0, 0, 0);
        mBtnLeft.setVisibility(VISIBLE);
        if(VISIBLE != mBtnRight.getVisibility()) {
            mBtnRight.setVisibility(INVISIBLE);
        }
        return this;
    }

    /**
     * 配置左按钮2
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @return 当前标题栏对象
     */
    private TitleBar setLeftButton2(int iconResId, int textResId) {
        mBtnLeft2.setText(0 == textResId ? "" : getResources().getText(textResId));
        mBtnLeft2.setCompoundDrawablesWithIntrinsicBounds(iconResId, 0, 0, 0);
        mBtnLeft2.setVisibility(VISIBLE);
        if(VISIBLE != mBtnRight.getVisibility()) {
            mBtnRight2.setVisibility(INVISIBLE);
        }
        return this;
    }

    /**
     * 配置右按钮
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @return 当前标题栏对象
     */
    private TitleBar setRightButton(int iconResId, int textResId) {
        mBtnRight.setText(0 == textResId ? "" : getResources().getText(textResId));
        mBtnRight.setCompoundDrawablesWithIntrinsicBounds(0, 0, iconResId, 0);
        mBtnRight.setVisibility(VISIBLE);
        if(VISIBLE != mBtnLeft.getVisibility()) {
            mBtnLeft.setVisibility(INVISIBLE);
        }
        return this;
    }

    /**
     * 配置右按钮2
     * @param iconResId 图标资源id，没有传0
     * @param textResId 文字资源id，没有传0
     * @return 当前标题栏对象
     */
    private TitleBar setRightButton2(int iconResId, int textResId) {
        mBtnRight2.setText(0 == textResId ? "" : getResources().getText(textResId));
        mBtnRight2.setCompoundDrawablesWithIntrinsicBounds(0, 0, iconResId, 0);
        mBtnRight2.setVisibility(VISIBLE);
        if(VISIBLE != mBtnLeft.getVisibility()) {
            mBtnLeft2.setVisibility(INVISIBLE);
        }
        return this;
    }
}