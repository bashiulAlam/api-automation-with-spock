package com.konasl.endtoendtest.httprequesthelper

import com.konasl.endtoendtest.configuration.ConfigPropertiesUtil
import com.konasl.endtoendtest.endpoints.MAPEndPoints
import com.konasl.endtoendtest.helper.ExceptionHepler
import com.konasl.endtoendtest.helper.WalletHelper
import com.konasl.endtoendtest.model.UserInfo
import com.konasl.endtoendtest.utils.Constants
import com.konasl.endtoendtest.utils.HeaderBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovyx.net.http.RESTClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UserRegistrationRequestHelper {
    private static Logger logger = LoggerFactory.getLogger(UserRegistrationRequestHelper.class)

    static def restClient = new RESTClient(ConfigPropertiesUtil.APIG_BASE_URL)
    static def jsonSlurper = new JsonSlurper()

    static def contentType = "application/json"

    static def getUserDetails(String mobileNo) {
        def response
        try {
            def path = MAPEndPoints.GET_USER_DETAILS
            restClient.setUri(ConfigPropertiesUtil.MAP_BASE_URL)

            def request = [
                    mobileNo: mobileNo
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

    static def login(UserInfo userInfo) {
        def response
        try {
            def path = MAPEndPoints.LOGIN
            restClient.setUri(ConfigPropertiesUtil.APIG_BASE_URL)

            def request = [
                    username: userInfo.userName,
                    password: userInfo.walletInfo.walletPin,
                    mpaId   : userInfo.walletInfo.mpaId,
                    aspId   : userInfo.aspId
                    //userId  : userInfo.userId
            ]

            logger.info("\nRequest URL: " + restClient.getUri().toString() + path + "\nRequest data : " + JsonOutput.toJson(request))

            def correlationHeader = new HeaderBuilder()
                    .addUserAgent(userInfo.userAgent)
                    .addAspId(userInfo.aspId)
                    .addUsingSecureKeyboard("Y")
                    .addAppCode("01")
                    .build()

            response = restClient.post(
                    path: path,
                    requestContentType: contentType,
                    headers: correlationHeader,
                    body: request
            )

            logger.info("\nResponse data for user login: " + JsonOutput.toJson(response.data))
            //WalletHelper.getCorrelationHeader(response, Constants.CORRELATION_ID)

            return response
        } catch (Exception ex) {
            //logger.info(ex.printStackTrace())
            return ExceptionHepler.handleException(ex)
        }
    }
}
