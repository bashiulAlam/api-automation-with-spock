package com.assignment.endtoendtest.utils;

import com.assignment.endtoendtest.configuration.ConfigPropertiesUtil;

public class Constants {
    public static final String API_KEY = ConfigPropertiesUtil.API_KEY;

    public static final String BASE_URL = ConfigPropertiesUtil.GOOGLE_MAPS_BASE_URL;

    public class TokenType {
        public static final String X_AUTH_TOKEN = "X-KM-AUTH-TOKEN";
        public static final String REFRESH_TOKEN = "X-KM-REFRESH-TOKEN";
    }
}
