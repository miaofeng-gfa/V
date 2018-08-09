package com.veeca.ted.v.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Ted on 2017/7/26.
 */

public class SharedPrefenencesUtils {

    private static final String FILE_NAME = "veeca_data";
    private static SharedPreferences mySharedPreference;
    private static SharedPrefenencesUtils instance;
    SharedPreferences.Editor editor;

    public SharedPrefenencesUtils(Context context) {
        mySharedPreference = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        editor = mySharedPreference.edit();
    }

    /**
     * 使用同步锁避免多线程的同步问题
     */
    public static synchronized void init(Context context) {
        if (instance == null) {
            instance = new SharedPrefenencesUtils(context);
        }
    }

    public static SharedPrefenencesUtils getInstance() {
        if (instance == null) {
            throw new RuntimeException("class should init!");
        }
        return instance;
    }

    public void saveData(String key, Object data) {
        String type = data.getClass().getSimpleName();

        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) data);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) data);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) data);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) data);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) data);
        }
        editor.commit();
    }

    public Object getData(String key, Object defValue) {
        String type = defValue.getClass().getSimpleName();
        if ("Integer".equals(type)) {
            return mySharedPreference.getInt(key, (Integer) defValue);
        } else if ("Boolean".equals(type)) {
            return mySharedPreference.getBoolean(key, (Boolean) defValue);
        } else if ("String".equals(type)) {
            return mySharedPreference.getString(key, (String) defValue);
        } else if ("Float".equals(type)) {
            return mySharedPreference.getFloat(key, (Float) defValue);
        } else if ("Long".equals(type)) {
            return mySharedPreference.getLong(key, (Long) defValue);
        }
        return null;
    }

    public void clearData() {
        editor.clear();
        editor.commit();
    }
}
