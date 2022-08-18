package com.assurity.assignment.framework.business.api.category;

import com.assurity.assignment.framework.business.api.FunctionBase;
import com.assurity.assignment.framework.model.api.request.ApiRequest;
import com.assurity.assignment.framework.model.api.response.ApiResponse;
import com.assurity.assignment.framework.model.api.response.category.Category;

import java.util.HashMap;
import java.util.Map;

import static com.assurity.assignment.framework.common.api.Constants.API_RESOURCE_PATH_CATEGORIES;
import static com.assurity.assignment.framework.common.api.Constants.API_URL;

public class CategoryFunctions extends FunctionBase {

    /**
     * Find a category
     *
     * @param categoryId {@link String}
     * @param isRequiredCatalog {@link Boolean}
     * @return {@link Category} object
     */
    public Category getCategory(String categoryId, boolean isRequiredCatalog) {
        String url = String.format(API_URL + API_RESOURCE_PATH_CATEGORIES, categoryId);
        Map<String, Object> queryParams = new HashMap<>(1);
        queryParams.put("catalogue", isRequiredCatalog);
        ApiRequest apiRequest = new ApiRequest(url, null, null, queryParams);
        ApiResponse apiResponse = httpClient.get(apiRequest);
        return jacksonUtil.convert(apiResponse.getResponseBody(), Category.class);
    }
}
