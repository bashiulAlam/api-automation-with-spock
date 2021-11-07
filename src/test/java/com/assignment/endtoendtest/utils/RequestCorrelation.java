package com.assignment.endtoendtest.utils;

public class RequestCorrelation {

    public static final String CORRELATION_ID_HEADER = "X-KM-Correlation-Id";
    public static final String ASP_ID_HEADER = "X-KM-User-AspId";
    public static final String USER_ID_HEADER = "X-KM-UserId";
    public static final String USER_NAME_HEADER = "X-KM-UserName";
    public static final String MPA_ID_HEADER = "X-KM-User-MpaId";
    public static final String EMAIL_HEADER = "X-KM-User-Email";
    public static final String PHONE_NUMBER_HEADER = "X-KM-User-Phone";
    public static final String CARD_ID_HEADER = "X-CardId";

    public static final String JMS_CORRELATION_ID_HEADER = "XCorrelationId";
    public static final String JMS_MPA_ID_HEADER = "XMpaId";
    public static final String JMS_USER_ID_HEADER = "XUserId";
    public static final String JMS_CARD_ID_HEADER = "XCardId";

    private static final ThreadLocal<String> id = new ThreadLocal<String>();
    private static final ThreadLocal<String> cardId = new ThreadLocal<String>();
    private static final ThreadLocal<String> aspId = new ThreadLocal<String>();
    private static final ThreadLocal<String> userId = new ThreadLocal<>();
    private static final ThreadLocal<String> userName = new ThreadLocal<>();
    private static final ThreadLocal<String> mpaId = new ThreadLocal<>();
    private static final ThreadLocal<String> email = new ThreadLocal<>();
    private static final ThreadLocal<String> phoneNumber = new ThreadLocal<>();


    public static String getId() {
        return id.get();
    }

    public static String getAspId() {
        return aspId.get();
    }

    public static String getUserId() {
        return userId.get();
    }

    public static String getUserName() {
        return userName.get();
    }

    public static String getEmail() {
        return email.get();
    }

    public static String getPhoneNumber() {
        return phoneNumber.get();
    }

    public static String getCardId() {
        return cardId.get();
    }

    public static String getMpaId() {
        return mpaId.get();
    }

    public static void setId(String val) {
        id.set(val);
    }

    public static void setAspId(String val) {
        aspId.set(val);
    }

    public static void setUserName(String val) {
        userName.set(val);
    }

    public static void setEmail(String val) {
        email.set(val);
    }

    public static void setPhoneNumber(String val) {
        phoneNumber.set(val);
    }

    public static void setCardId(String val) {
        cardId.set(val);
    }

    public static void setUserId(String val) {
        userId.set(val);
    }

    public static void setMpaId(String val) {
        mpaId.set(val);
    }

}
