package com.assignment.endtoendtest.configuration;

import java.util.Properties;

public class ConfigPropertiesUtil {
    public static String GOOGLE_MAPS_BASE_URL;
    public static String API_KEY;

    public interface ConfigElements {
        static final String SERVER_IP = "GOOGLE_MAPS_BASE_URL";
        static final String API_KEY = "API_KEY";
    }

    static {
        Properties configProperties = Configuration.loadProperties(Configuration.PROPERTY_FILE_NAME);

        GOOGLE_MAPS_BASE_URL = configProperties.getProperty(ConfigElements.SERVER_IP);
        API_KEY = configProperties.getProperty(ConfigElements.API_KEY);
    }
}
