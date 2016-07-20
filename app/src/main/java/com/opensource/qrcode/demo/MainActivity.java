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

package com.opensource.qrcode.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.opensource.qrcode.CaptureActivity;
import com.opensource.qrcode.QRCodeResult;

/**
 * 主Activity
 * Created by yinglovezhuzhu@gmail.com on 2016/7/20.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private static final int RC_SCAN_QR_CODE = 100;

    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_scan:
                startActivityForResult(new Intent(this, CaptureActivity.class), RC_SCAN_QR_CODE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(RESULT_OK == resultCode && RC_SCAN_QR_CODE == requestCode) {
            if(data.hasExtra(CaptureActivity.EXTRA_DATA)) {
                QRCodeResult result = data.getParcelableExtra(CaptureActivity.EXTRA_DATA);
                mTvText.setText(result.toString());
            }
        }
    }

    private void initView() {
        mTvText = (TextView) findViewById(R.id.tv_main_text);
    }
}
