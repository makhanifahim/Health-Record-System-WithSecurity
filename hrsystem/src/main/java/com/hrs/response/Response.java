package com.hrs.response;

import lombok.Data;

import java.util.Date;

@Data
public class Response {
    private String message;
    private Boolean status;
    private Date timeStamp;
    static Response response;

    public static Response send(String m, Boolean s) {
        response = new Response();
        response.message = m;
        response.status = s;
        response.timeStamp = new Date();
        return response;
    }
}
