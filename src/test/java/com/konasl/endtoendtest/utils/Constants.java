package com.konasl.endtoendtest.utils;

import com.konasl.endtoendtest.configuration.ConfigPropertiesUtil;

public class Constants {
    public static final String ASP_ID = ConfigPropertiesUtil.ASP_ID;
    public static final String USER_AGENT = ConfigPropertiesUtil.USER_AGENT;

    public static final String CORRELATION_ID = "X-KM-Correlation-Id";

    public class TokenType {
        public static final String X_AUTH_TOKEN = "X-KM-AUTH-TOKEN";
        public static final String REFRESH_TOKEN = "X-KM-REFRESH-TOKEN";
    }
}
