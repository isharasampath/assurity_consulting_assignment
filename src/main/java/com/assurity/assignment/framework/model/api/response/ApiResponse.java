package com.assurity.assignment.framework.model.api.response;

public class ApiResponse {
    private String responseMessage;
    private String responseBody;
    private int responseCode;

    public ApiResponse(String responseMessage, String responseBody, int responseCode) {
        this.responseMessage = responseMessage;
        this.responseBody = responseBody;
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
