package com.archish.makeawish.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Archish on 7/29/2017.
 */

public class Success implements Parcelable {
    private boolean status;
    private String message;

    public Success(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    protected Success(Parcel in) {
        status = in.readByte() != 0;
        message = in.readString();
    }

    public static final Creator<Success> CREATOR = new Creator<Success>() {
        @Override
        public Success createFromParcel(Parcel in) {
            return new Success(in);
        }

        @Override
        public Success[] newArray(int size) {
            return new Success[size];
        }
    };

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (status ? 1 : 0));
        dest.writeString(message);
    }
}
