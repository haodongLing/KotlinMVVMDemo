package com.haodong.kotlinmvvmdemo.model.api

import com.haodong.lib.common.model.bean.User
import com.haodong.lib.common.model.WanResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Author: tangyuan
 * Time : 2021/8/16
 * Description:
 */
interface UserService {

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): WanResponse<User>

    @GET("/user/logout/json")
    suspend fun logOut(): WanResponse<Any>

    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(@Field("username") userName: String, @Field("password") passWord: String, @Field("repassword") rePassWord: String): WanResponse<User>
}