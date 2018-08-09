package com.veeca.ted.v.bean;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by niu on 2017/7/1.
 *
 * 本地通讯录信息
 */

public class ContactBean {



    private String name;
    private String phoneNumber;

    public String getName() {
        if (TextUtils.isEmpty(name)){
            return "";
        }
        return name;
    }

    public String getPhoneNumber() {
        if (TextUtils.isEmpty(phoneNumber)){
            return "";
        }
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)){
            if (TextUtils.isEmpty(this.phoneNumber)){
                this.phoneNumber="";
            }
        }else {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n|");
            Matcher m = p.matcher(phoneNumber);
            phoneNumber = m.replaceAll("");
            phoneNumber = phoneNumber.replaceAll("\\-", "");
            if (TextUtils.isEmpty(this.phoneNumber)){
                this.phoneNumber=phoneNumber;
            }else {
                this.phoneNumber+=","+phoneNumber;
            }
        }

    }

    public void setName(String name) {
        if (TextUtils.isEmpty(name)){
            this.name="";
        }else {

            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"phoneNumber\":\"" + phoneNumber + '\"' +
                '}';
    }
}
