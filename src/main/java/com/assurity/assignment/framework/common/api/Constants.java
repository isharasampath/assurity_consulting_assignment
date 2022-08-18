package com.assurity.assignment.framework.common.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Constants {

    private static final Properties properties = new Properties();

    /**
     * Load the property file at class loading time
     */
    static {
        String resourceName = "framework_configs.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final int HTTP_REQUEST_TIMEOUT = Integer.parseInt(Optional.ofNullable(
            properties.getProperty("http.request.timeout")).orElse("60"));
    public static final String API_URL = Optional.ofNullable(properties.getProperty("api.base.url")).orElse("");
    public static final String API_RESOURCE_PATH_CATEGORIES = Optional.ofNullable(properties
            .getProperty("api.resource.path.categories")).orElse("");


}
