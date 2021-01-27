package com.konasl.endtoendtest.configuration;

import java.util.Properties;

public class ConfigPropertiesUtil {
    public static final String  ASP_ID;
    public static final String LOCALE;
    public static final String USER_AGENT;

    public static String SERVER_IP;

    public static final String APIGW_PORT;
    public static final String MAP_PORT;

    public static final String APIG_BASE_URL;
    public static final String MAP_BASE_URL;

    public interface ConfigElements {
        static final String ASP_ID = "ASP_ID";
        static final String LOCALE = "LOCALE";
        static final String USER_AGENT = "USER_AGENT";

        static final String SERVER_IP = "DFS_QA_IP";

        static final String APIGW_PORT = "APIGW_PORT";
        static final String MAP_PORT = "MAP_PORT";
    }

    static {
        Properties configProperties = Configuration.loadProperties(Configuration.PROPERTY_FILE_NAME);

        ASP_ID = configProperties.getProperty(ConfigElements.ASP_ID);
        LOCALE = configProperties.getProperty(ConfigElements.LOCALE);
        USER_AGENT = configProperties.getProperty(ConfigElements.USER_AGENT);

        SERVER_IP = configProperties.getProperty(ConfigElements.SERVER_IP);

        APIGW_PORT = configProperties.getProperty(ConfigElements.APIGW_PORT);
        MAP_PORT = configProperties.getProperty(ConfigElements.MAP_PORT);

        APIG_BASE_URL = SERVER_IP + ":" + APIGW_PORT;
        MAP_BASE_URL = SERVER_IP + ":" + MAP_PORT;
    }
}
