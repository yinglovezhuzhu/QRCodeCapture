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

package com.opensource.qrcode;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.util.Arrays;

/**
 * QRCode result data
 * Created by yinglovezhuzhu@gmail.com on 2016/7/20.
 */
public class QRCodeResult implements Parcelable {
    private String text;
    private byte [] rawBytes;
    private BarcodeFormat format;

    private QRCodeResult(Parcel source) {
        this.text = source.readString();
        this.rawBytes = source.createByteArray();
        format = (BarcodeFormat) source.readSerializable();
    }

    public QRCodeResult() {

    }

    public QRCodeResult(Result result) {
        if(null == result) {
            return;
        }
        this.text = result.getText();
        this.rawBytes = result.getRawBytes();
        this.format = result.getBarcodeFormat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeByteArray(rawBytes);
        dest.writeSerializable(format);
    }

    public static Creator<QRCodeResult> CREATOR = new Creator<QRCodeResult>() {
        @Override
        public QRCodeResult createFromParcel(Parcel source) {
            return new QRCodeResult(source);
        }

        @Override
        public QRCodeResult[] newArray(int size) {
            return new QRCodeResult[size];
        }
    };

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getRawBytes() {
        return rawBytes;
    }

    public void setRawBytes(byte[] rawBytes) {
        this.rawBytes = rawBytes;
    }

    public BarcodeFormat getFormat() {
        return format;
    }

    public void setFormat(BarcodeFormat format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "QRCodeResult{" +
                "text='" + text + '\'' +
                ", rawBytes=" + Arrays.toString(rawBytes) +
                ", format=" + format +
                '}';
    }
}
