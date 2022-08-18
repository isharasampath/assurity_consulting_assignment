package com.assurity.assignment.framework.api.clientimpl;

import com.assurity.assignment.framework.api.HttpClientService;
import com.assurity.assignment.framework.model.api.request.ApiRequest;
import com.assurity.assignment.framework.model.api.response.ApiResponse;
import com.assurity.assignment.framework.utils.api.LoggerUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.params.CoreConnectionPNames;

import java.util.Map;

import static com.assurity.assignment.framework.common.api.Constants.HTTP_REQUEST_TIMEOUT;

public class RestAssuredClientImpl implements HttpClientService {

    /**
     * Http get method client implementation
     *
     * @param apiRequest {@link ApiRequest}
     * @return {@link ApiResponse} object
     */
    @Override
    public ApiResponse get(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().get(apiRequest.getUrl());
            LoggerUtil.getLogger().info("Status Code: {}", response.statusCode());
            LoggerUtil.getLogger().info("Response: {}", response.asString());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Http post method client implementation
     *
     * @param apiRequest {@link ApiRequest}
     * @return {@link ApiResponse} object
     */
    @Override
    public ApiResponse post(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().post(apiRequest.getUrl());
            LoggerUtil.getLogger().info("Status Code: {}", response.statusCode());
            LoggerUtil.getLogger().info("Response: {}", response.asString());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Http put method client implementation
     *
     * @param apiRequest {@link ApiRequest}
     * @return {@link ApiResponse} object
     */
    @Override
    public ApiResponse put(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().put(apiRequest.getUrl());
            LoggerUtil.getLogger().info("Status Code: {}", response.statusCode());
            LoggerUtil.getLogger().info("Response: {}", response.asString());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Http patch method client implementation
     *
     * @param apiRequest {@link ApiRequest}
     * @return {@link ApiResponse} object
     */
    @Override
    public ApiResponse patch(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().patch(apiRequest.getUrl());
            LoggerUtil.getLogger().info("Status Code: {}", response.statusCode());
            LoggerUtil.getLogger().info("Response: {}", response.asString());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Http delete method client implementation
     *
     * @param apiRequest {@link ApiRequest}
     * @return {@link ApiResponse} object
     */
    @Override
    public ApiResponse delete(ApiRequest apiRequest) {
        try {
            RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(apiRequest.getHeader()
                    , apiRequest.getJsonBody(), apiRequest.getQueryParams()));
            Response response = requestSpecification.expect().when().delete(apiRequest.getUrl());
            LoggerUtil.getLogger().info("Status Code: {}", response.statusCode());
            LoggerUtil.getLogger().info("Response: {}", response.asString());
            return new ApiResponse(response.asString(), response.body().asString(), response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Create request specification based on user inputs.
     *
     * @param headers {@link Map}. Set null if not required
     * @param body {@link String}. Set null if not required
     * @param queryParameters {@link Map}. Set null if not required
     * @return {@link RequestSpecification} object
     */
    private RequestSpecification getRequestSpec(Map<String, String> headers, String body, Map<String, Object> queryParameters) {
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();

        reqSpecBuilder.setConfig(RestAssured.config().httpClient(getHttpClientConfig()));

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

    /**
     * Create http client configuration
     *
     * @return {@link HttpClientConfig} object
     */
    private HttpClientConfig getHttpClientConfig() {
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.setParam(ClientPNames.CONN_MANAGER_TIMEOUT, HTTP_REQUEST_TIMEOUT);
        httpClientConfig.setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, HTTP_REQUEST_TIMEOUT);
        httpClientConfig.setParam(CoreConnectionPNames.SO_TIMEOUT, HTTP_REQUEST_TIMEOUT);
        httpClientConfig.setParam(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
        return httpClientConfig;
    }
}
