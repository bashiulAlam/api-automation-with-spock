package com.assignment.endtoendtest.helper


import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ExceptionHelper {

    private static Logger logger = LoggerFactory.getLogger(com.assignment.endtoendtest.specification.APITestSpec.class)

    static def handleException(Exception ex) {
        logger.error("Exception occurred : " + ex.getMessage() + "\nStack trace for the exception: " + ex.getStackTrace())

        /*String message = ex.getMessage();
        message = message.substring(message.indexOf("=") + 1, message.indexOf(","))
        return Integer.parseInt(message)*/
        /*if(ex.response.hasProperty('data')) {
            logger.error("\nResponse data : " + JsonOutput.toJson(ex.response.data))
            return ex.response.data
        } else {
            logger.error("\nResponse data : " + JsonOutput.toJson(ex.response))
            return ex.response
        }*/
    }
}
