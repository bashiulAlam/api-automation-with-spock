package com.konasl.endtoendtest.helper

import org.slf4j.LoggerFactory

import org.slf4j.Logger;

public class WalletHelper {
    private static Logger logger = LoggerFactory.getLogger(WalletHelper.class)

    static def getCorrelationHeader(def response, String headerType) {
        try {
            List headers = response.responseBase.headergroup.headers
            Map<String, String> map = new HashMap<String, String>()
            for (Object header : headers) {
                String[] pair = header.toString().split(":")
                map.put(pair[0], pair[1])
            }
            logger.info("\n" + headerType + " : " + map.get(headerType))
            return map.get(headerType)
        }
        catch (Exception ex) {
            logger.error("Exception occurred : " + ex.getMessage() + "\nStack trace for the exception: " + ex.getStackTrace())
        }
    }

    static def extractHeaderValue(List headers, String headerType) {
        try {
            Map<String, String> map = new HashMap<String, String>()
            for (Object header : headers) {
                String[] pair = header.toString().split(":")
                map.put(pair[0], pair[1])
                logger.info("map content : " + map.get(pair[0]))
            }
            logger.info("\n" + headerType + " : " + map.get(headerType))
            return map.get(headerType)
        }
        catch (Exception ex) {
            logger.error("Exception occurred : " + ex.getMessage() + "\nStack trace for the exception: " + ex.getStackTrace())
        }
    }
}
