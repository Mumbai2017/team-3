package com.archish.makeawish.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Archish on 1/13/2017.
 */

public class UserResponse implements Parcelable {
    boolean success;
    String message;
    String accessToken;
    int role;

    public UserResponse(boolean success, String message, String accessToken, int role) {
        this.success = success;
        this.message = message;
        this.accessToken = accessToken;
        this.role = role;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCategory() {
        return role;
    }

    public void setCategory(int category) {
        this.role = category;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected UserResponse(Parcel in) {
    }

    public static final Creator<UserResponse> CREATOR = new Creator<UserResponse>() {
        @Override
        public UserResponse createFromParcel(Parcel in) {
            return new UserResponse(in);
        }

        @Override
        public UserResponse[] newArray(int size) {
            return new UserResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
