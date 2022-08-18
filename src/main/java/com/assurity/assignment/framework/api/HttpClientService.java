package com.assurity.assignment.framework.api;

import com.assurity.assignment.framework.model.api.request.ApiRequest;
import com.assurity.assignment.framework.model.api.response.ApiResponse;

public interface HttpClientService {

    /**
     * Abstract client method for http get request
     *
     * @param apiRequest {@link ApiRequest}
     * @return response object {@link ApiResponse}
     */
    public ApiResponse get(ApiRequest apiRequest);

    /**
     * Abstract client method for http post request
     *
     * @param apiRequest {@link ApiRequest}
     * @return response object {@link ApiResponse}
     */
    public ApiResponse post(ApiRequest apiRequest);

    /**
     * Abstract client method for http put request
     *
     * @param apiRequest {@link ApiRequest}
     * @return response object {@link ApiResponse}
     */
    public ApiResponse put(ApiRequest apiRequest);

    /**
     * Abstract client method for http patch request
     *
     * @param apiRequest {@link ApiRequest}
     * @return response object {@link ApiResponse}
     */
    public ApiResponse patch(ApiRequest apiRequest);

    /**
     * Abstract client method for http delete request
     *
     * @param apiRequest {@link ApiRequest}
     * @return response object {@link ApiResponse}
     */
    public ApiResponse delete(ApiRequest apiRequest);
}
