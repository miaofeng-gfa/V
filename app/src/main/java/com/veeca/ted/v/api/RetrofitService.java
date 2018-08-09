package com.veeca.ted.v.api;

import com.veeca.ted.v.bean.CircleData;
import com.veeca.ted.v.bean.FriMoneyThir;
import com.veeca.ted.v.bean.FriendMoney;
import com.veeca.ted.v.bean.Goods;
import com.veeca.ted.v.bean.IsFirstMoney;
import com.veeca.ted.v.bean.Login;
import com.veeca.ted.v.bean.MyWithdraw;
import com.veeca.ted.v.bean.NoRegisterFriend;
import com.veeca.ted.v.bean.QunList;
import com.veeca.ted.v.bean.QunTags;
import com.veeca.ted.v.bean.Recharge;
import com.veeca.ted.v.bean.RegisterFriend;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.RewardMoney;
import com.veeca.ted.v.bean.SumMoney;
import com.veeca.ted.v.bean.Syt;
import com.veeca.ted.v.bean.Task;
import com.veeca.ted.v.bean.TaskState;
import com.veeca.ted.v.bean.TaskV;
import com.veeca.ted.v.bean.Tasking;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.UserAllCard;
import com.veeca.ted.v.bean.UserV;
import com.veeca.ted.v.bean.VInfo;
import com.veeca.ted.v.bean.VLists;
import com.veeca.ted.v.bean.VLive;
import com.veeca.ted.v.bean.Version;
import com.veeca.ted.v.bean.VideoBuy;
import com.veeca.ted.v.bean.VideoCode;
import com.veeca.ted.v.bean.VideoPlayerItemInfo;
import com.veeca.ted.v.bean.VideoSee;
import com.veeca.ted.v.bean.VideoUrl;
import com.veeca.ted.v.bean.mian.AllCircle;
import com.veeca.ted.v.bean.mian.Buy;
import com.veeca.ted.v.bean.mian.Circle;
import com.veeca.ted.v.bean.mian.FriendCount;
import com.veeca.ted.v.bean.mian.FriendsMoney;
import com.veeca.ted.v.bean.mian.Gold;
import com.veeca.ted.v.bean.mian.HomeMoney;
import com.veeca.ted.v.bean.mian.Income;
import com.veeca.ted.v.bean.mian.Like;
import com.veeca.ted.v.bean.mian.MyMoney;
import com.veeca.ted.v.bean.mian.MyProfit;
import com.veeca.ted.v.bean.mian.Sign;
import com.veeca.ted.v.bean.mian.TaskLists;
import com.veeca.ted.v.bean.mian.UserBind;
import com.veeca.ted.v.bean.mian.UserCircle;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.bean.mian.UserLike;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Ted on 2017/11/15.
 */

public interface RetrofitService {

    //登录 获取验证码
    @POST("xiaovRegistry/sendCodeXiaovka.do")
    Observable<Results> getCode(@Query("phoneNum") String s);

    //登录 获取验证码
    @POST("xiaovRegistry/newNumSend.do")
    Observable<Results> getCode1(@Query("phoneNum") String s);

    //微信登录
    @FormUrlEncoded
    @POST("xiaovUserlogon/wxLogin.do")
    Observable<Login> login(@Field("headimgurl") String headimgurl,
                            @Field("nickname") String nickname,
                            @Field("sex") int sex,
                            @Field("country") String country,
                            @Field("province") String province,
                            @Field("city") String city,
                            @Field("openid") String openid,
                            @Field("unionid") String unionid);

    //绑定手机号
    /*@FormUrlEncoded
    @POST("xiaovUserlogon/boundPhoneNum.do")
    Observable<Results> getPhone(@Field("userid") String userid,
                                 @Field("token") String token,
                                 @Field("phoneNum") String phoneNum,
                                 @Field("code") String code);*/

    @FormUrlEncoded
    @POST("xiaovUserlogon/userPhoneLogin.do")
    Observable<Results> getPhone(
                                 @Field("phoneNum") String phoneNum,
                                 @Field("code") String code);
    //好友分红贡献
    @FormUrlEncoded
    @POST("xiaovUserlogon/userPhoneLogin.do")
    Observable<Results> getFriendsMoney(
                                 @Field("userid") String userid,
                                 @Field("token") String token);

    //上传身份信息
    @FormUrlEncoded
    @POST("xiaovUser/updateBySelective.do")
    Observable<Results> getUserCard(@Field("userid") String userid,
                                    @Field("token") String token,
                                    @Field("cardImg") String cardImg);

    //每日签到
    @FormUrlEncoded
    @POST("XiaovGoldController/getIsSign.do")
    Observable<Sign> getSign(@Field("userid") String userid,
                             @Field("token") String token);

    //签到确认
    @FormUrlEncoded
    @POST("XiaovGoldController/signGainGold.do")
    Observable<Results> getSignSuccess(@Field("userid") String userid,
                                       @Field("token") String token,
                                       @Field("gisign") int gisign,
                                       @Field("ginum") int ginum,
                                       @Field("inum") int inum);

    //我的收益弹窗
    @FormUrlEncoded
    @POST("XiaovPopController/toDayEarning.do")
    Observable<Income> getMainIncome(@Field("userid") String userid,
                                     @Field("token") String token);

    //获取版本号
    @FormUrlEncoded
    @POST("XiaovVersionController/getNewVersions.do")
    Observable<Version> getNewVersion(@Field("from") int from);

    //主页
    //获取用户信息
    @POST("xiaovUser/getXiaovUser.do")
    Observable<UserInfo> getUserInfo(@Query("userid") String userid,
                                     @Query("token") String token);

    //正在悬赏金额
    @POST("xiaovindex/getIndexMoney.do")
    Observable<HomeMoney> getMoney();

    //获取圈子
    @FormUrlEncoded
    @POST("XiaovStaticDataController/getXiaovStaticCircle.do")
    Observable<AllCircle> getAllCircle(@Field("isRecommend") int isRecommend);

    //获取圈子详情
    @FormUrlEncoded
    @POST("XiaovStaticDataController/getXiaovStaticCircleInfo.do")
    Observable<CircleData> getCircleData(@Field("scid") int scid);

    //判断中V是否上传名片
    @FormUrlEncoded
    @POST("xiaovUser/isCardAuth.do")
    Observable<Results> getWardCont(@Field("userid") String userid,
                                    @Field("token") String token);

    //流量缓存
    @FormUrlEncoded
    @POST("xiaovindex/hidProperties.do")
    Observable<Results> getProperties(@Field("userid") String userid,
                                      @Field("token") String token);

    //流量任务列表
    /*@FormUrlEncoded
    @POST("xiaovHuodong/selectHuodongListL.do")
    Observable<TaskLists> getTaskLists2(@Field("userid") String userid,
                                        @Field("token") String token,
                                        @Field("page") int page);*/
    //转发分红
    @FormUrlEncoded
    @POST("xiaovindex/getIndexHuodong.do")
    Observable<TaskLists> getTaskLists2(@Field("userid") String userid,
                                        @Field("token") String token,
                                        @Field("page") int page);

    //好友分红贡献
    @FormUrlEncoded
    @POST("VadsShareController/getAlreadyIc.do")
    Observable<FriendsMoney> getShareMoney(@Field("userid") String userid,
                                             @Field("token") String token,
                                           @Field("pid") int pid);

    //获取当前用户绑定的三方
    @POST("xiaovUser/getUserThirds.do")
    Observable<UserBind> getUserBind(@Query("userid") String userid,
                                     @Query("token") String token);

    //绑定微博
    @FormUrlEncoded
    @POST("xiaovUser/getUserThird.do")
    Observable<Results> upUserThird(@Field("userid") String userid,
                                    @Field("token") String token,
                                    @Field("type") int type,
                                    @Field("name") String name,
                                    @Field("openid") String openid,
                                    @Field("unionid") String unionid,
                                    @Field("headimgurl") String headimgurl,
                                    @Field("tcaccount") String tcaccount,
                                    @Field("fans") String fans);

    //绑定QQ微信
    @FormUrlEncoded
    @POST("xiaovUser/getUserThird.do")
    Observable<Results> upUserThird1(@Field("userid") String userid,
                                     @Field("token") String token,
                                     @Field("type") int type,
                                     @Field("name") String name,
                                     @Field("openid") String openid,
                                     @Field("unionid") String unionid,
                                     @Field("headimgurl") String headimgurl,
                                     @Field("tcaccount") String tcaccount);

    //绑定第三方3
    @FormUrlEncoded
    @POST("xiaovUser/getUserThird3.do")
    Observable<Results> upUserThird2(@Field("userid") String userid,
                                     @Field("token") String token,
                                     @Field("type") int type,
                                     @Field("tcauthimgurl") String tcauthimgurl,
                                     @Field("name") String name);

    //查询微信是否上传截图
    @FormUrlEncoded
    @POST("xiaovThird/getWxIsAuth.do")
    Observable<Results> getWX(@Field("userid") String userid,
                              @Field("token") String token,
                              @Field("type") int type);

    //上传好友认证照片
    @FormUrlEncoded
    @POST("xiaovThird/authUserInfluence.do")
    Observable<Results> upUserPhoto(@Field("userid") String userid,
                                    @Field("token") String token,
                                    @Field("type") int type,
                                    @Field("tcauthimgurl") String tcauthimgurl);

    //成为小V提交审核
    @FormUrlEncoded
    @POST("xiaovUser/submitCheckXiaov.do")
    Observable<Results> upV(@Field("userid") String userid,
                            @Field("token") String token);

    //绑定身份证号
    @FormUrlEncoded
    @POST("xiaovUser/userIDCardAuth.do")
    Observable<Results> upCard(@Field("userid") String userid,
                               @Field("token") String token,
                               @Field("IDCardName") String IDCardName,
                               @Field("IDCard") String IDCard);

    //绑定所在地区
    @FormUrlEncoded
    @POST("xiaovUser/updateProvince.do")
    Observable<Results> upAddress(@Field("userid") String userid,
                                  @Field("token") String token,
                                  @Field("province") String province);

    //上传通讯录
    @FormUrlEncoded
    @POST("XiaovCelController/addXiaovCelByAndroid.do")
    Observable<Results> getPhone(@Field("userid") String userid,
                                 @Field("token") String token,
                                 @Field("jsonStr") String jsonStr);

    //查询V币
    @FormUrlEncoded
    @POST("XiaovGoldController/selectXiaovGoldSum.do")
    Observable<Gold> getGold(@Field("userid") String userid,
                             @Field("token") String token);

    //查询分红收益明细
    @FormUrlEncoded
    @POST("xiaovUser/friendMoneyList.do")
    Observable<MyProfit> getMyProfitList(@Field("userid") String userid,
                                         @Field("token") String token,
                                         @Field("page") int page,
                                         @Field("size") int size);

    //查询赏金明细
    @FormUrlEncoded
    @POST("xiaovUser/myBillInfo.do")
    Observable<MyMoney> getMyMoneyList(@Field("userid") String userid,
                                       @Field("token") String token,
                                       @Field("page") int page,
                                       @Field("size") int size);

    //查询提现明细
    @FormUrlEncoded
    @POST("xiaovUser/myBillInfoTX.do")
    Observable<MyWithdraw> getMyWithdrawList(@Field("userid") String userid,
                                             @Field("token") String token,
                                             @Field("page") int page,
                                             @Field("size") int size);

    //我的赏金
    @FormUrlEncoded
    @POST("xiaovUser/myRewardMoney.do")
    Observable<Tasking> getTasking(@Field("userid") String userid,
                                   @Field("token") String token,
                                   @Field("type") int type,
                                   @Field("page") int page,
                                   @Field("size") int size);

    //大咖推荐
    @POST("XiaovFlockRecController/getXiaovFlockRecByRec.do")
    Observable<VLists> getV();

    //群标签分类
    @POST("XiaovFlockSignController/getXiaovFlockSign.do")
    Observable<QunTags> getQunTags();

    //查看所有群
    @POST("XiaovFlockController/selectFlockFree.do")
    Observable<QunList> getQun(@Query("uid") String uid,
                               @Query("page") int page,
                               @Query("size") int size,
                               @Query("fstate") int fstate,
                               @Query("sign") int sign);

    //7天收益图
    @FormUrlEncoded
    @POST("xiaovUser/myDayEarningsDrawingSeven.do")
    Observable<Syt> getSyt7(@Field("userid") String userid,
                            @Field("token") String token);

    //30天收益图
    @FormUrlEncoded
    @POST("xiaovUser/myDayEarningsDrawingMonth.do")
    Observable<Syt> getSyt30(@Field("userid") String userid,
                             @Field("token") String token);

    //分红好友数30天
    @FormUrlEncoded
    @POST("VadsShareController/getPartFriendNumMonth.do")
    Observable<FriMoneyThir> getFriendMoney30(@Field("userid") String userid,
                                              @Field("token") String token);

    //获取已注册列表:
    @FormUrlEncoded
    @POST("VadsShareController/getRegisterFriend.do")
    Observable<RegisterFriend> getRegisterFriend(@Field("userid") String userid,
                                                 @Field("token") String token,
                                                 @Field("page") int page);
    //获取未注册列表
    @FormUrlEncoded
    @POST("VadsShareController/getNotRegisterFriend.do")
    Observable<NoRegisterFriend> getNotRegisterFriend(@Field("userid") String userid,
                                                      @Field("token") String token,
                                                      @Field("page") int page);

    //查询赏金收益
    @FormUrlEncoded
    @POST("xiaovUser/rewardMoney.do")
    Observable<RewardMoney> getRewardMoney(@Field("userid") String userid,
                                           @Field("token") String token);

    //查询分红收益
    @FormUrlEncoded
    @POST("xiaovUser/friendMoney.do")
    Observable<FriendMoney> getFriendMoney(@Field("userid") String userid,
                                           @Field("token") String token);

    //查询总收益
    @FormUrlEncoded
    @POST("xiaovUser/sumMoney.do")
    Observable<SumMoney> getSumMoney(@Field("userid") String userid,
                                     @Field("token") String token);
    //获取好友数
    @FormUrlEncoded
    @POST("VadsShareController/getFriendCount.do")
    Observable<FriendCount> getFriendCounts(@Field("userid") String userid,
                                            @Field("token") String token);

    //查询可用金额
    @FormUrlEncoded
    @POST("xiaovUser/usableMoney.do")
    Observable<UsableMoney> getUsableMoney(@Field("userid") String userid,
                                           @Field("token") String token);

    //支付宝提现
    @FormUrlEncoded
    @POST("xiaovAlipy/ALiPayWithdraw.do")
    Observable<Results> getExtract(@Field("userid") String userid,
                                   @Field("token") String token,
                                   @Field("amount") String amount);
    //是否首次提现
    @FormUrlEncoded
    @POST("xiaovAlipy/isTxAll.do")
    Observable<IsFirstMoney> isTxAll(@Field("userid") String userid,
                                     @Field("token") String token);
    //微信提现
    @FormUrlEncoded
    @POST("wxTransferController/transferPay.do")
    Observable<Results> getCashWeiXin(@Field("userid") String userid,
                                            @Field("token") String token,
                                            @Field("amount") String amount);

    //支付宝充值
    @FormUrlEncoded
    @POST("XiaovChargeMoneyController/chargeMoney.do")
    Observable<Recharge> getRecharge(@Field("userid") String userid,
                                     @Field("token") String token,
                                     @Field("money") double money);

    //绑定支付宝
    @FormUrlEncoded
    @POST("XiaovBoundALiController/faceAuthALi.do")
    Observable<Results> getBindALiPay(@Field("userid") String userid,
                                      @Field("token") String token,
                                      @Field("name") String name,
                                      @Field("card") String card,
                                      @Field("account") String account);

    //获取提现绑定
    @FormUrlEncoded
    @POST("XiaovBoundController/queryBoundInfo.do")
    Observable<UserAllCard> getAllCard(@Field("userid") String userid,
                                       @Field("token") String token);

    //参与小V前10个
    @FormUrlEncoded
    @POST("xiaovHuodong/selectJoinHuodongLUser.do")
    Observable<TaskV> getTaskV(@Field("hid") int hid);

    //参与小V全部
    @FormUrlEncoded
    @POST("xiaovHuodong/selectJoinHuodongLUserList.do")
    Observable<TaskV> getTaskAllV(@Field("hid") int hid,
                                  @Field("page") int page,
                                  @Field("size") int size);

    //流量详情
    @FormUrlEncoded
    @POST("xiaovHuodong/selectHuodongLInfo.do")
    Observable<Task> getTask(@Field("userid") String userid,
                             @Field("token") String token,
                             @Field("hid") int hid);

    //分享
    @FormUrlEncoded
    @POST("xiaovShare/successShareHuodongL.do")
    Observable<Results> getShare(@Field("userid") String userid,
                                 @Field("token") String token,
                                 @Field("hid") int hid);

    //获取用户对该任务的状态
    @FormUrlEncoded
    @POST("xiaovShare/ckeckStatus.do")
    Observable<TaskState> getUserTaskState(@Field("userid") String userid,
                                           @Field("token") String token,
                                           @Field("hid") int hid);

    //进群
    @FormUrlEncoded
    @POST("XiaovFlockPaymentController/paymentFlock.do")
    Observable<Results> getJoinQun(@Field("userid") String userid,
                                   @Field("token") String token,
                                   @Field("fid") int fid,
                                   @Field("money") double money,
                                   @Field("wxAccount") String wxAccount,
                                   @Field("sign") int sign,
                                   @Field("free") int free);

    //获取圈子
    @POST("xiaovCircle/getCircle.do")
    Observable<Circle> getApproveCircle(@Query("userid") String userid,
                                        @Query("token") String token);

    //获取兴趣
    @POST("xiaovLabel/getLabel.do")
    Observable<Like> getApproveLike(@Query("userid") String userid,
                                    @Query("token") String token);


    //获取用户已选择的兴趣
    @POST("xiaovUser/getUserLabel.do")
    Observable<UserLike> getUserLike(@Query("userid") String userid,
                                     @Query("token") String token);

    //获取用户已选择的圈子
    @POST("xiaovUser/getUserCircle.do")
    Observable<UserCircle> getUserCircle(@Query("userid") String userid,
                                         @Query("token") String token);


    //保存个人信息
    @FormUrlEncoded
    @POST("xiaovUser/comeXiaovOne.do")
    Observable<Results> getMyProfile(@Field("userid") String userid,
                                     @Field("token") String token,
                                     @Field("headimhurl") String headimhurl,
                                     @Field("nickname") String nickname,
                                     @Field("province") String province,
                                     @Field("labelIds") String labelIds,
                                     @Field("circleIds") String circleIds);

    //小V用户
    @FormUrlEncoded
    @POST("XiaovStaticDataController/getUserInfo.do")
    Observable<UserV> getUserV(@Field("uid") int uid);

    //今日大咖
    @FormUrlEncoded
    @POST("XiaovFlockRecController/getXiaovFlockRecInfo.do")
    Observable<VInfo> getVInfo(@Field("rid") int rid);

    //今日大咖Tag
    @FormUrlEncoded
    @POST("XiaovRecTagController/selectTagByRid.do")
    Observable<List<String>> getVTag(@Field("rid") int rid);

    //查询平台
    @FormUrlEncoded
    @POST("XiaovRecStreamController/selectXiaovRecStreamByRid.do")
    Observable<List<VLive>> getVLive(@Field("rid") int rid);

    //今日大咖打赏
    @FormUrlEncoded
    @POST("XiaovRecBiddingController/addXiaovRecBidding.do")
    Observable<Results> getReward(@Field("uid") int uid,
                                  @Field("money") String money,
                                  @Field("wxAccount") String wxAccount,
                                  @Field("rid") int rid,
                                  @Field("num") int num);

    //今日大咖约播
    @FormUrlEncoded
    @POST("XiaovRecLiveController/addXiaovRecLive.do")
    Observable<Results> getEngagement(@Field("rsid") int rsid,
                                      @Field("rid") int rid,
                                      @Field("uid") int uid,
                                      @Field("shareUrl ") String shareUrl);

    //卖手列表
    @FormUrlEncoded
    @POST("XiaovVideoController/getXiaovVideoList.do")
    Observable<VideoPlayerItemInfo> getVideos(@Field("page") int page);

    //卖手商品详情
    @FormUrlEncoded
    @POST("XiaovVideoController/getProductByVid.do")
    Observable<Goods> getGoods(@Field("vid") int vid);

    //获取二维码信息
    @FormUrlEncoded
    @POST("XiaovVideoController/getXiaovVideoH5.do")
    Observable<VideoCode> getVideoCode(@Field("vid") int vid);

    //获取分享链接
    @FormUrlEncoded
    @POST("XiaovVideoController/sharingVideo.do")
    Observable<VideoUrl> getVideoUrl(@Field("userid") String userid,
                                     @Field("token") String token,
                                     @Field("vid") int vid);

    //分享成功
    @FormUrlEncoded
    @POST("XiaovDividualController/addDividual.do")
    Observable<Results> getCodeSuccess(@Field("userid") String userid,
                                       @Field("pid") int pid,
                                       @Field("vid") int vid);

    //销售分红
    @FormUrlEncoded
    @POST("XiaovBuyHistoryController/getSalesProductProfit.do")
    Observable<Buy> getBuy(@Field("userid") String userid,
                           @Field("token") String token);

    //谁看了
    @FormUrlEncoded
    @POST("XiaovLookController/getXiaovLookByUid.do")
    Observable<VideoSee> getVideoSee(@Field("userid") String userid,
                                     @Field("token") String token,
                                     @Field("page") int page);

    //谁买了
    @FormUrlEncoded
    @POST("XiaovBuyHistoryController/getXiaovButHistoryByUid.do")
    Observable<VideoBuy> getVideoBuy(@Field("userid") String userid,
                                     @Field("token") String token,
                                     @Field("page") int page);

    //播放调用
    @FormUrlEncoded
    @POST("XiaovVideoController/updateVideoPlayNumByVid.do")
    Observable<Results> getplay(@Field("vid") int vid);

}
