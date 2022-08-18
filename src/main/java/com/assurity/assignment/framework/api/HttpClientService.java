package com.assurity.assignment.framework.api;

import com.assurity.assignment.framework.model.api.request.ApiRequest;
import com.assurity.assignment.framework.model.api.response.ApiResponse;

public interface HttpClientService {

    public ApiResponse get(ApiRequest apiRequest);

    public ApiResponse post(ApiRequest apiRequest);

    public ApiResponse put(ApiRequest apiRequest);

    public ApiResponse patch(ApiRequest apiRequest);

    public ApiResponse delete(ApiRequest apiRequest);
}
