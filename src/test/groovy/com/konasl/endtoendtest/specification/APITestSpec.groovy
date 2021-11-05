package com.konasl.endtoendtest.specification

import com.konasl.endtoendtest.helper.WalletHelper
import com.konasl.endtoendtest.httprequesthelper.SampleApiRequestHelper
import com.konasl.endtoendtest.httprequesthelper.UserRegistrationRequestHelper
import com.konasl.endtoendtest.model.UserInfo
import com.konasl.endtoendtest.model.WalletInfo
import com.konasl.endtoendtest.utils.Constants
import com.konasl.endtoendtest.utils.Utils
import groovy.json.JsonSlurper
import net.sf.json.JSONArray
import net.sf.json.JSONObject
import org.junit.Rule
import org.junit.rules.TestName
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class APITestSpec extends Specification {
    private static Logger logger = LoggerFactory.getLogger(APITestSpec.class)

    @Shared
    userList = new ArrayList<UserInfo>()

    @Rule
    TestName testName = new TestName()

    def jsonSlurper = new JsonSlurper()
    static def scenarioCount = 1
    static def scenarioSerial = Utils.formatNumber(scenarioCount)

    def setupSpec() {
        def userInfo1 = new UserInfo()
        userInfo1.aspId = Constants.ASP_ID
        userInfo1.userAgent = Constants.USER_AGENT
        userInfo1.walletInfo = new WalletInfo()

        userList.add(0, userInfo1)

        logger.info("Setup Spec method executed...")
    }

    def setup() {
        logger.info("\n\n============================== Scenario - " + testName.methodName + " ==============================\n")
        ++scenarioCount
        scenarioSerial = Utils.formatNumber(scenarioCount)
    }

    @Ignore
    @Unroll
    def "(#scenarioSerial) Get User Details"() {
        given: "a register user"

        when: "we attempt to get user details"
        def response = UserRegistrationRequestHelper.getUserDetails(mobileNo)

        then: "we receive a response"
        //System.out.println("Response status : " + response.data.executionStatus.statusType)
        response.data.executionStatus.statusType == responseStatus

        where: "a set of parameters"
        mobileNo | responseStatus | scenarioSerial
        "01599993333" | "EXECUTED_SUCCESS" | scenarioSerial
    }

    @Ignore
    @Unroll
    def "(#scenarioSerial) User Login"() {
        given: "a registered user"
        userList[userSerial].userId = userId
        userList[userSerial].userName = userName
        userList[userSerial].walletInfo.walletPin = walletPin
        userList[userSerial].walletInfo.mpaId = mpaId

        when: "we attempt to login the registered user"
        def response = UserRegistrationRequestHelper.login(userList[userSerial])

        /*and: "We prepare header with x-auth-token for initWallet"
        ArrayList<Object> headers = response.responseBase.headergroup.headers
        String headerStr = headers.toString()
        headerStr = headerStr.substring(1, headerStr.length() - 1)
        List<String> headerList = headerStr.split(",")
        logger.info("Header List: " + headerList)

        userList[userSerial].walletInfo.X_AUTH_TOKEN = WalletHelper.extractHeaderValue(headerList, Constants.TokenType.X_AUTH_TOKEN)
        userList[userSerial].walletInfo.REFRESH_TOKEN = WalletHelper.extractHeaderValue(headerList, Constants.TokenType.REFRESH_TOKEN)*/

        then: "we receive a response"
        response.data.userId != null

        where: "a set of parameters"
        userSerial | userId | mpaId | userName | walletPin | responseStatus | scenarioSerial
        0 | "248290" | "16115573050055407153522155852177" | "01521437368" | "B3282A2F2A28757B3A18AB833DE16A9C54518C0B0CF493E3F0A7CF09386F326A" | "EXECUTED_SUCCESS" | scenarioSerial
    }

    @Unroll
    def "(#scenarioSerial) Get User Info"() {
        given: "We have users registered"

        when: "We attempt to get user info"
        def response = SampleApiRequestHelper.getUserInfoByPageNo(pageNo)

        then: "We receive a response"
        response.data.total != 0

        where: "a set of parameters"
        pageNo | scenarioSerial
        2 | scenarioSerial
    }
}
