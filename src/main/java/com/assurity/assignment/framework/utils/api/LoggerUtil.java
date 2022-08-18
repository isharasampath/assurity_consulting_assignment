package com.assurity.assignment.framework.utils.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    private static Logger logger = null;

    static {
        logger = LoggerFactory.getLogger("Info Data");
    }

    public static Logger getLogger() {
        return logger;
    }
}
