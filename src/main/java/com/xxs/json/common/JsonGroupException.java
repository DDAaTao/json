package com.xxs.json.common;

import lombok.Data;

/**
 * @author van
 */
public class JsonGroupException extends Exception {
    private String code;

    public JsonGroupException(String message) {
        super(message);
    }

    public JsonGroupException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
