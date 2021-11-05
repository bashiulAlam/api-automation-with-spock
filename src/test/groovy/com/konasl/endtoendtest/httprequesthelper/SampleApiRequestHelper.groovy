package com.konasl.endtoendtest.httprequesthelper

import com.konasl.endtoendtest.configuration.ConfigPropertiesUtil
import com.konasl.endtoendtest.endpoints.MAPEndPoints
import com.konasl.endtoendtest.helper.ExceptionHepler
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovyx.net.http.RESTClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class SampleApiRequestHelper {
    private static Logger logger = LoggerFactory.getLogger(UserRegistrationRequestHelper.class)

    static def restClient = new RESTClient(ConfigPropertiesUtil.SERVER_IP)
    static def jsonSlurper = new JsonSlurper()

    static def contentType = "application/json"

    static def getUserInfoByPageNo(def pageNo) {
        def response
        try {
            def path = "/api/users"

            def request = [
                    page: pageNo
            ]

            logger.info("\nRequest URL: " + restClient.getUri().toString() + path + "\nRequest data : " + JsonOutput.toJson(request))

            response = restClient.get(
                    path: path,
                    contentType: contentType,
                    query: request
            )

            logger.info("\nResponse data : " + JsonOutput.toJson(response.data))

            return response
        } catch (Exception ex) {
            return ExceptionHepler.handleException(ex)
        }
    }
}
