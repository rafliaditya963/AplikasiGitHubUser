package com.example.aplikasigithubuser.data.retrofit

import com.example.aplikasigithubuser.data.response.DetailUserResponse
import com.example.aplikasigithubuser.data.response.GithubResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users")
    fun getSearchUsers(
        @Query("q") query : String
    ): Call<GithubResponse>

    @GET("users/{username}")
    fun getDetailUser(@Path("username") username: String): Call<DetailUserResponse>

    @GET("users/{username}/follower")
    fun getFollowers(
        @Query("username") username : String
    ): Call<GithubResponse>

    @GET("users/{username}/following")
    fun getFollowing(
        @Query("username") username : String
    ): Call<GithubResponse>
}