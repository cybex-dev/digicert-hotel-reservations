package com.digicert.hotelreservations.models;

import java.util.HashMap;
import java.util.Map;

public class RESTDataResponse<T> {
    private boolean status;
    private T data;
    private Map<String, Object> metadata;

    public RESTDataResponse(boolean status, T data) {
        this.status = status;
        this.data = data;
        this.metadata = new HashMap<>();
    }

    public RESTDataResponse(boolean status, T data, Map<String, Object> metadata) {
        this.status = status;
        this.data = data;
        this.metadata = metadata;
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

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
