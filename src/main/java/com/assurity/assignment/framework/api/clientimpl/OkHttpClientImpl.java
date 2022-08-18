package com.assurity.assignment.framework.api.clientimpl;

import com.assurity.assignment.framework.api.HttpClientService;
import com.assurity.assignment.framework.model.api.request.ApiRequest;
import com.assurity.assignment.framework.model.api.response.ApiResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.assurity.assignment.framework.common.api.Constants.HTTP_REQUEST_TIMEOUT;

public class OkHttpClientImpl implements HttpClientService {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @Override
    public ApiResponse get(ApiRequest apiRequest) {
        try {
            OkHttpClient client = getClient();
            Headers headers = buildHeaders(apiRequest);
            Request request = new Request.Builder()
                    .url(apiRequest.getUrl())
                    .get()
                    .headers(headers)
                    .build();

            Response response = client.newCall(request).execute();
            return new ApiResponse(response.message(), response.body().string(), response.code());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse post(ApiRequest apiRequest) {
        try {
            OkHttpClient client = getClient();
            Headers headers = buildHeaders(apiRequest);
            RequestBody body = RequestBody.create(apiRequest.getJsonBody(), JSON);

            Request request = new Request.Builder()
                    .url(apiRequest.getUrl())
                    .post(body)
                    .headers(headers)
                    .build();
            Response response = client.newCall(request).execute();
            return new ApiResponse(response.message(), response.body().string(), response.code());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse put(ApiRequest apiRequest) {
        try {
            OkHttpClient client = getClient();
            Headers headers = buildHeaders(apiRequest);
            RequestBody body = RequestBody.create(apiRequest.getJsonBody(), JSON);

            Request request = new Request.Builder()
                    .url(apiRequest.getUrl())
                    .put(body)
                    .headers(headers)
                    .build();
            Response response = client.newCall(request).execute();
            return new ApiResponse(response.message(), response.body().string(), response.code());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse patch(ApiRequest apiRequest) {
        try {
            OkHttpClient client = getClient();
            Headers headers = buildHeaders(apiRequest);
            RequestBody body = RequestBody.create(apiRequest.getJsonBody(), JSON);

            Request request = new Request.Builder()
                    .url(apiRequest.getUrl())
                    .patch(body)
                    .headers(headers)
                    .build();
            Response response = client.newCall(request).execute();
            return new ApiResponse(response.message(), response.body().string(), response.code());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse delete(ApiRequest apiRequest) {
        try {
            OkHttpClient client = getClient();
            Headers headers = buildHeaders(apiRequest);
            Request request = new Request.Builder()
                    .url(apiRequest.getUrl())
                    .delete()
                    .headers(headers)
                    .build();

            Response response = client.newCall(request).execute();
            return new ApiResponse(response.message(), response.body().string(), response.code());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private OkHttpClient getClient() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(HTTP_REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HTTP_REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_REQUEST_TIMEOUT, TimeUnit.SECONDS).build();
    }

    private Headers buildHeaders(ApiRequest apiRequest) {
        Headers headers = null;
        if (apiRequest.getHeader() != null) {
            headers = Headers.of(apiRequest.getHeader());
        } else {
            Map<String, String> hdrs = new HashMap<>();
            hdrs.put("Content-Type", "application/json;charset=utf-8");
            hdrs.put("Accept", "application/json, text/plain");
            headers = Headers.of(hdrs);
        }
        return headers;
    }
}
