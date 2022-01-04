package com.assignment.endtoendtest.specification

import com.assignment.endtoendtest.httprequesthelper.GoogleApiRequestHelper
import com.assignment.endtoendtest.utils.Utils
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import net.sf.json.JSONObject
import org.jsoup.Connection
import org.jsoup.nodes.Document
import org.junit.Rule
import org.junit.rules.TestName
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll
import jodd.json.*

class APITestSpec extends Specification {
    private static Logger logger = LoggerFactory.getLogger(APITestSpec.class)

    @Rule
    TestName testName = new TestName()

    def jsonSlurper = new JsonSlurper()
    static def scenarioCount = 1
    static def scenarioSerial = Utils.formatNumber(scenarioCount)

    def setupSpec() {
        logger.info("Setup Spec method executed...")
    }

    def setup() {
        logger.info("\n\n============================== Scenario - " + testName.methodName + " ==============================\n")
        ++scenarioCount
        scenarioSerial = Utils.formatNumber(scenarioCount)
    }

    @Unroll
    def "(#scenarioSerial) Get Directions"() {
        given: "We have directions api"

        when: "We attempt to get direction between two places"
        Connection.Response response = GoogleApiRequestHelper.getDirections(destination, origin) as Connection.Response
        Document document = response.parse()
        logger.info("Response data : " + document.toString())
        //logger.info("Json body data : " + JsonOutput.toJson(document.body().text()))
        logger.info("Json body data : " + JsonSerializer.create().serialize(document.body().text()))
        logger.info("Status code : " + response.statusCode())

        then: "We receive a response"
        response.statusCode() == statusCode

        where: "a set of parameters"
        destination                   | origin                        | statusCode | scenarioSerial
        "Victoria, BC"                | "Vancouver, BC"               | 200        | Utils.formatNumber(scenarioCount)
        "38.5, -75"                   | "38.8951, -77.0364"           | 200        | Utils.formatNumber(scenarioCount + 1)
        "ChIJgWsCh7C4VTcRwgRZ3btjpY8" | "ChIJMdA4aqnv-zkREPTWDpU6-RA" | 400        | Utils.formatNumber(scenarioCount + 2)
        "QCF8+7C Dhaka"               | "Q965+G4 Dhaka"               | 200        | Utils.formatNumber(scenarioCount + 3)
        "QCF8+7C Dhaka"               | "SARA M Square"               | 200        | Utils.formatNumber(scenarioCount + 4)
        "Victoria, BC"                | "SARA M Square"               | 200        | Utils.formatNumber(scenarioCount + 5)
        "38.5, -75"                   | "SARA M Square"               | 200        | Utils.formatNumber(scenarioCount + 6)
    }

    @Unroll
    def "(#scenarioSerial) Get Place From Text"() {
        given: "We have places api"

        when: "We attempt to get place details"
        Connection.Response response = GoogleApiRequestHelper.getPlaceFromText(place) as Connection.Response
        Document document = response.parse()
        logger.info("Response data : " + document.toString())
//        logger.info("Json body data : " + JsonOutput.toJson(document.body().text()))
        logger.info("Json body data : " + JsonSerializer.create().serialize(document.body().text()))
        logger.info("Status code : " + response.statusCode())

//        def jsonBody = jsonSlurper.parseText(document.body().text())
        def jsonBody = JsonParser.create().parse(document.body().text())
        logger.info("status : " + jsonBody.status)

        then: "We receive a response"
        response.statusCode() == statusCode

        where: "a set of parameters"
        place                                     | statusCode | scenarioSerial
        "SARA M Square"                           | 200        | Utils.formatNumber(scenarioCount)
        "Q965+G4 Dhaka"                           | 200        | Utils.formatNumber(scenarioCount + 1)
        "House # 55/2 & 58, Rd No. 2, Dhaka 1207" | 200        | Utils.formatNumber(scenarioCount + 2)
        "+8801847214963"                          | 200        | Utils.formatNumber(scenarioCount + 3)
        "ChIJMdA4aqnv-zkREPTWDpU6-RA"             | 200        | Utils.formatNumber(scenarioCount + 4)
        "+88027911042"                            | 200        | Utils.formatNumber(scenarioCount + 5)
    }

    @Unroll
    def "(#scenarioSerial) Geolocate"() {
        given: "We have geolocate api"

        when: "We attempt to get geolocate data"
        Connection.Response response = GoogleApiRequestHelper.geolocate() as Connection.Response
        logger.info("Status code : " + response.statusCode())

        then: "We receive a response"
        response.statusCode() == statusCode

        where: "a set of parameters"
        statusCode | scenarioSerial
        404        | scenarioSerial
    }
}
