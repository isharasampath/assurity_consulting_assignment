package com.assurity.assignment.framework.api.clientimpl;

import com.assurity.assignment.framework.api.HttpClientService;
import com.assurity.assignment.framework.model.api.request.ApiRequest;
import com.assurity.assignment.framework.model.api.response.ApiResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.params.ClientPNames;

import java.util.Map;
public class RestAssuredClientImpl implements HttpClientService {
    @Override
    public ApiResponse get(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().get(apiRequest.getUrl());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse post(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().post(apiRequest.getUrl());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse put(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().put(apiRequest.getUrl());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse patch(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().patch(apiRequest.getUrl());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse delete(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().delete(apiRequest.getUrl());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private RequestSpecification getRequestSpec(Map<String, String> headers, String body, Map<String, Object> queryParameters) {
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();

        reqSpecBuilder.setConfig(RestAssured.config());

        if (headers != null) {
            reqSpecBuilder.addHeaders(headers);
        }

        if (body != null && body.length() > 0) {
            reqSpecBuilder.setBody(body);
        }

        if (queryParameters != null && !queryParameters.isEmpty())
            reqSpecBuilder.addQueryParams(queryParameters);

        return reqSpecBuilder.build();
    }
}
