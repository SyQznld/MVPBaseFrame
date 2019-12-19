package com.appler.mvpbaseframe.api;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by appler on 2018/9/19.
 */

public interface ApiService {
    /**
     * GET
     */
    @FormUrlEncoded
    @POST("Post_Login")
    Observable<ResponseBody> getLoginResult(
            @Field("Name") String Account,
            @Field("Password") String Password,
            @Field("IsAndroid") String IsAndroid,
            @Field("RegistrationID") String registrationID);


    /**
     * POST
     */
    @FormUrlEncoded
    @POST("Post_Create_MouldName")
    Observable<ResponseBody> loadModel(
            @Field("Id") String id,
            @Field("Name") String name,
            @Field("OldName") String oldname,
            @Field("SortList") Integer[] sortlist,
            @Field("cNameList") String[] cNameList);




    /**
     * GET
     */
    @FormUrlEncoded
    @POST("")
    Observable<ResponseBody> testFrame( @Field("RegistrationID") String registrationID);



}
