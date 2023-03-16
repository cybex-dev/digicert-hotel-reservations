package com.digicert.hotelreservations.models;

public class RESTDataResponse<T> {
    private boolean status;
    private T data;

    public RESTDataResponse(boolean status, T data) {
        this.status = status;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
