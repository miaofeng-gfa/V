package com.veeca.ted.v.constant;

/**
 * Created by Ted on 2017/11/14.
 */

public class Constant {

    private static String userId;
    private static String token;
    private static int userState;
    private static int onFirst;
    private static int userRep;
    private static int isV;
    private static String RSA = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoUOa/QtOMGvwv2fDUiY98tUueFsxi55sAoDBXy7vQ6CjjvzrCo/t+W1khgc4/199JPzJKHhpctVij5Js+VeUpX2bK4aLQ1gk6Pt0JUShf8WljX59TUDPJLy+K6iJvh99eZXVq/ajOD6LlUagMqJq2xS/ftmm2FT/IE3BW93z4SQIDAQAB";

    public static String getRSA() {
        return RSA;
    }

    public static final String URL = "http://xiaovapppic.xiaovka.com/";

    public static int getIsV() {
        return isV;
    }

    public static void setIsV(int isV) {
        Constant.isV = isV;
    }

    public static int getUserRep() {
        return userRep;
    }

    public static void setUserRep(int userRep) {
        Constant.userRep = userRep;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        Constant.userId = userId;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Constant.token = token;
    }

    public static int getUserState() {
        return userState;
    }

    public static void setUserState(int userState) {
        Constant.userState = userState;
    }

    public static int getOnFirst() {
        return onFirst;
    }

    public static void setOnFirst(int onFirst) {
        Constant.onFirst = onFirst;
    }
}
