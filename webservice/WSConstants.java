package com.example.retofit.webservice;

/**
 * Common webservice constants.
 */

public class WSConstants {

    /**
     * Webservice url
     */
    static final String WS_BASE_URL = "http://…”//base url
    /**
     * Webservice headers
     */
    static final String WS_HEADER_AUTHENTICATION = "userRegistration";
    static final String WS_HEADER_ORIGIN = "Origin: 12345";
    /**
     * Webservice methods
     */
    static final String WS_METHOD_USERS_REGISTRATION = "userRegistration";
    static final String WS_METHOD_USERS_LOGIN = "userLogin";
    static final String WS_METHOD_FORGOT_PASSWORD = "forgotPassword";
    static final String WS_METHOD_SET_PASSWORD = "setPassword";
    static final String WS_METHOD_USERS_LOGOUT = "userLogout";
    static final String WS_METHOD_USERS_PROFILE = "getUserProfile";
    static final String WS_METHOD_UPDATE_PROFILE = "userUpdateProfile";

    /**
     * Webservice parameters
     */
    static final String WS_PARAM_ID = "id";
    static final String WS_PARAM_FLAG = "flag";
    static final String WS_PARAM_USERS_ID = "userId";
    static final String WS_PARAM_HOTEL_ID = "hotel_id";

    public static final String WS_PARAM_PROFILE_PIC = "profilePic";
    static final String WS_PARAM_PROFILE_IMAGE = "profile_image";

    public static final String WS_STATUS_SUCCESS = "1";
    public static final String WS_STATUS_FAIL = "0";

    public static final String WS_RESPONSE_DATA = "data";
    public static final String WS_RESPONSE_SETTINGS = "settings";

    static final int WS_CONNECTION_TIMEOUT = 60;
    static final int WS_READ_TIMEOUT = 60;
}