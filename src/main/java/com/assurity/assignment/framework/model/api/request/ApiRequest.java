package com.assurity.assignment.framework.model.api.request;

import java.util.Map;

/**
 * Data transfer object for http request data
 */
public class ApiRequest {
    private String url;
    private String jsonBody;
    private Map<String, String> header;
    private Map<String, Object> queryParams;

    public ApiRequest(String url, String jsonBody, Map<String, String> header, Map<String, Object> queryParams) {
        setUrl(url);
        setJsonBody(jsonBody);
        setHeader(header);
        setQueryParams(queryParams);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody == null ? "" : jsonBody;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
    }
}
