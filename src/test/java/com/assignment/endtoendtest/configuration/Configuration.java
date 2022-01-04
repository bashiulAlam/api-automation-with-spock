package com.assignment.endtoendtest.configuration;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public static final String PROPERTY_FILE_NAME = "config";
    private static final String PROPERTY_FILE_NAME_SEPARATOR = "-";
    private static final String PROPERTY_FILE_EXTENTION = ".properties";
    private static final String TARGET_PROFILE_PARAM_NAME = "endToEndTestProfile";
    private static Logger logger = LoggerFactory.getLogger(Configuration.class);

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        String strBuildProfile = System.getenv(TARGET_PROFILE_PARAM_NAME);
        if (strBuildProfile == null) {
            strBuildProfile = "";
        }
        strBuildProfile = strBuildProfile.trim().toLowerCase();
        if (strBuildProfile.length() > 0) {
            strBuildProfile = PROPERTY_FILE_NAME_SEPARATOR + strBuildProfile;
        }
        strBuildProfile =
                fileName +
                        strBuildProfile +
                        PROPERTY_FILE_EXTENTION;
        InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream(strBuildProfile);
        try {
            properties.load(inputStream);
            logger.info("Load Properties " + strBuildProfile + ": Loaded Successfully.");
        } catch (IOException e) {
            Assert.fail("Failed to load" + strBuildProfile);
        }
        return properties;
    }
}
