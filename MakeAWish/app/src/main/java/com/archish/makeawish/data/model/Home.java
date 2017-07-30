package com.archish.makeawish.data.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Home implements Parcelable {
    int hid;
    String ptitle;
    String wish;
    String date;
    String ofthewish;
    String rushWish;
    int status;
    String location;

    public Home(int hid, String ptitle, String wish, String date, String rushWish, int status, String location) {
        this.hid = hid;
        this.ptitle = ptitle;
        this.wish = wish;
        this.date = date;
        this.rushWish = rushWish;
        this.status = status;
        this.location = location;
    }

    protected Home(Parcel in) {
        hid = in.readInt();
        ptitle = in.readString();
        wish = in.readString();
        date = in.readString();
        rushWish = in.readString();
        status = in.readInt();
    }

    public static final Creator<Home> CREATOR = new Creator<Home>() {
        @Override
        public Home createFromParcel(Parcel in) {
            return new Home(in);
        }

        @Override
        public Home[] newArray(int size) {
            return new Home[size];
        }
    };

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRushWish() {
        return rushWish;
    }

    public void setRushWish(String rushWish) {
        this.rushWish = rushWish;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hid);
        dest.writeString(ptitle);
        dest.writeString(wish);
        dest.writeString(date);
        dest.writeString(rushWish);
        dest.writeInt(status);
    }
}
