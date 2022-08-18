package com.assurity.assignment.framework.business.api;

import com.assurity.assignment.framework.api.HttpClientService;
import com.assurity.assignment.framework.api.clientimpl.RestAssuredClientImpl;
import com.assurity.assignment.framework.utils.api.JacksonUtil;

/**
 * Base class for all the API level function implementations. All the API function classes should be inherit from this class.
 */
public class FunctionBase {

    protected JacksonUtil jacksonUtil = new JacksonUtil();
    protected HttpClientService httpClient = new RestAssuredClientImpl();
}
