package com.airlook.kwapp.rx5;

import com.airlook.kwapp.rx5.model.BaseModel;
import com.airlook.kwapp.rx5.model.LoginResultModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NetService {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello")
    Observable<Translation> translate();


    @GET("ajax.php?a=fy&f=auto&t=auto&w=register")
    Observable<Translation> translate2();


    @GET("ajax.php?a=fy&f=auto&t=auto&w=login")
    Observable<Translation> translate3();

    /**
     * 验证码登录接口
     */
    @FormUrlEncoded
    @POST("http://testapp.airspace.cn/api/passport/app/login")
    Observable<BaseModel<Object>> queryLogin(@Field("loginName") String loginName
            , @Field("mobile") String mobile
            , @Field("smsCode") String smsCode
            , @Field("deviceVersion") String deviceVersion      //手机型号
            , @Field("deviceOsVersion") String deviceOsVersion  //安卓版本号
            , @Field("appVersion") String appVersion            //app版本号
    );


    /**
     * 获取验证码
     */
    @GET("http://testapp.airspace.cn/api/passport/app/getSmsCode")
    Observable<BaseModel<Object>> querySmsCode(@Query("loginName") String loginName  //登录名传入手机号
            , @Query("mobile") String mobile
            , @Query("type") int type);

}
