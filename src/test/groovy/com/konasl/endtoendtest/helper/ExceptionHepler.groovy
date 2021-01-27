package com.konasl.endtoendtest.helper

import com.konasl.endtoendtest.specification.APITestSpec
import com.konasl.endtoendtest.utils.Constants
import groovy.json.JsonOutput
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ExceptionHepler {

    private static Logger logger = LoggerFactory.getLogger(APITestSpec.class)

    static def handleException(Exception ex) {
        //WalletHelper.getCorrelationHeader(ex.response, Constants.CORRELATION_ID)
        logger.error("Exception occurred : " + ex.getMessage() + "\nStack trace for the exception: " + ex.getStackTrace())
        if(ex.response.hasProperty('data')) {
            logger.error("\nResponse data : " + JsonOutput.toJson(ex.response.data))
            return ex.response.data
        }
        else {
            logger.error("\nResponse data : " + JsonOutput.toJson(ex.response))
            return ex.response
        }
    }
}
