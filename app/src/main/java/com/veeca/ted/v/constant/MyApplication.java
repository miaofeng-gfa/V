package com.veeca.ted.v.constant;

import android.app.Application;
import android.content.Context;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.squareup.leakcanary.LeakCanary;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.veeca.ted.v.BuildConfig;
import com.veeca.ted.v.utils.SharedPrefenencesUtils;

//import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Ted on 2017/11/14.
 */

public class MyApplication extends Application {

    private static Context sAppContext;
    private static MyApplication instance;

    //OSS的Bucket
    public static final String OSS_BUCKET = "xiaovapp";
    //设置OSS数据中心域名或者cname域名
    public static final String OSS_BUCKET_HOST_ID = "https://oss-cn-qingdao.aliyuncs.com";
    //Key
    private static final String accessKey = "LTAIg3ZdSzXFUs46";
    private static final String screctKey = "b7enlZcom8LZVwQGV9XIGfbV3AP1ZM";

    public static OSS oss;

    // 单例模式中获取唯一的MyApplication实例
    public static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }

    public MyApplication() {
        sAppContext = getAppContext();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
//        Config.DEBUG = false;
        Config.DEBUG = true;
        UMShareAPI.get(this);
        LeakCanary.install(this);
        SharedPrefenencesUtils.init(sAppContext);
        //初始化OSS配置
        initOSSConfig();
    }

    private void initOSSConfig() {
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKey, screctKey);
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        if (BuildConfig.DEBUG) {
            OSSLog.enableLog();
        }
        oss = new OSSClient(getApplicationContext(), MyApplication.OSS_BUCKET_HOST_ID, credentialProvider, conf);
    }

    //各个平台的配置
    {
        //微信
//        PlatformConfig.setWeixin("wxfcede6aaaec44642", "4075f12796d7eec1de9151f305b69a70");
        PlatformConfig.setWeixin("wxec1166d10f38b231", "185e18bc8dd8de556bae385ab82a5748");
        //新浪微博(第三个参数为回调地址)
        PlatformConfig.setSinaWeibo("167390708", "9352d6bc2c0647bd5655c7f27f42f063", "http://www.sina.com");
        //QQ
        PlatformConfig.setQQZone("1106272193", "rewPglOcxmyj1p2p");
    }

    public static final SHARE_MEDIA[] displaylist = {SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
            SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.SINA /*,SHARE_MEDIA.DOUBAN*/};
}
