package com.dantorrey.httpdump.value;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RequestDetails {

    public String httpRequestType;
    public String url;
    public String body;
    public Map<String,String> headers;

    @JsonProperty("request_type")
    public String getHttpRequestType() {
        return httpRequestType;
    }

    public void setHttpRequestType(String httpRequestType) {
        this.httpRequestType = httpRequestType;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("headers")
    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
