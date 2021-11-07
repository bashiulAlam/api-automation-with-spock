package com.assignment.endtoendtest.utils;
import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {
    public static final String X_AUTH_TOKEN = "X-KM-AUTH-TOKEN";
    public static final String REFRESH_TOKEN = "X-KM-REFRESH-TOKEN";
    public static final String USER_AGENT = "X-KM-User-Agent";
    public static final String REQUEST_TYPE = "requestType";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String GET = "GET";
    public static final String X_KM_PASS_AUTH = "X-KM-PASS-AUTH";
    public static final String X_KM_USING_SECURE_KEYBOARD = "X-KM-USING-SECURE-KEYBOARD";
    public static final String PAR = "PAR";
    public static final String SERVICEID = "SERVICEID";
    public static final String ASP_ID_HEADER_PORTAL = "X-KM-User-AspId";
    public static final String APP_CODE = "X-KM-AppCode";

    String par = null;
    String serviceId = null;
    String userId = null;
    String mpaId = null;
    String cardId = null;
    String aspId = null;
    String appCode = null;
    String requestType = null;
    String xAuthToken = null;
    String refreshToken = null;
    String userAgent = null;
    String versionCode = null;
    String passwordAuthorization = null;
    String usingSecureKeyboard = null;

    public HeaderBuilder() {
    }

    public HeaderBuilder(String userId, String mpaId, String cardId) {
        this.userId = userId;
        this.mpaId = mpaId;
        this.cardId = cardId;
    }

    public HeaderBuilder(String userId, String mpaId, String cardId, String requestType) {
        this.userId = userId;
        this.mpaId = mpaId;
        this.cardId = cardId;
        this.requestType = requestType;
    }

    public HeaderBuilder addUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public HeaderBuilder addAspId(String aspId) {
        this.aspId = aspId;
        return this;
    }

    public HeaderBuilder addMpaId(String mpaId) {
        this.mpaId = mpaId;
        return this;
    }

    public HeaderBuilder addVersionCode(String versionCode) {
        this.versionCode = versionCode;
        return this;
    }

    public HeaderBuilder addCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public HeaderBuilder addRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public HeaderBuilder addXAuthToken(String xAuthToken) {
        this.xAuthToken = xAuthToken;
        return this;
    }

    public HeaderBuilder addRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public HeaderBuilder addUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public HeaderBuilder addAppCode(String appCode) {
        this.appCode = appCode;
        return this;
    }

    public HeaderBuilder addPasswordAuthorization(String passwordAuthorization)
    {
        this.passwordAuthorization=passwordAuthorization;
        return this;
    }
    public HeaderBuilder addUsingSecureKeyboard(String usingSecureKeyboard)
    {
        this.usingSecureKeyboard=usingSecureKeyboard;
        return this;
    }

    public HeaderBuilder addPar(String par)
    {
        this.par = par;
        return this;
    }

    public HeaderBuilder addServiceId(String serviceId)
    {
        this.serviceId = serviceId;
        return this;
    }

    public Map<String, String> build() {
        Map<String, String> result = new HashMap<String, String>();
        if (userId != null) {
            result.put(RequestCorrelation.USER_ID_HEADER, this.userId);
        }
        if (mpaId != null) {
            result.put(RequestCorrelation.MPA_ID_HEADER, this.mpaId);
        }
        if (cardId != null) {
            result.put(RequestCorrelation.CARD_ID_HEADER, this.cardId);
        }
        if (requestType != null) {
            result.put(REQUEST_TYPE, this.requestType);
        }
        if (xAuthToken != null) {
            result.put(X_AUTH_TOKEN, this.xAuthToken);
        }
        if (aspId != null) {
            result.put(ASP_ID_HEADER_PORTAL, this.aspId);
        }
        if (refreshToken != null) {
            result.put(REFRESH_TOKEN, this.refreshToken);
        }

        if (passwordAuthorization != null){
            result.put(X_KM_PASS_AUTH, this.passwordAuthorization);
        }
        if (usingSecureKeyboard != null){
            result.put(X_KM_USING_SECURE_KEYBOARD, this.usingSecureKeyboard);
        }

        if (userAgent != null) {
            result.put(USER_AGENT, this.userAgent);
        }
        if (appCode != null) {
            result.put(APP_CODE, this.appCode);
        }

        return result;
    }
}
