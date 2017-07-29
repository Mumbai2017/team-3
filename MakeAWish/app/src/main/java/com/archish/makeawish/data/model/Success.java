package com.archish.makeawish.data.model;

/**
 * Created by Archish on 7/29/2017.
 */

public class Success {
    private boolean status;
    private String message;

    public Success(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

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
}
