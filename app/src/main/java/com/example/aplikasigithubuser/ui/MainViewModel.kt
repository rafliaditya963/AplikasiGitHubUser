package com.example.aplikasigithubuser.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasigithubuser.data.response.DetailUserResponse
import com.example.aplikasigithubuser.data.response.GithubResponse
import com.example.aplikasigithubuser.data.response.ItemsItem
import com.example.aplikasigithubuser.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query


class MainViewModel : ViewModel() {

    private val _listUser = MutableLiveData<List<ItemsItem>>()
    val listUser: LiveData<List<ItemsItem>> = _listUser

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object {
        private val TAG = "MainViewModel"
        private var query = "rafli"
    }

    init {
        findUser()
    }

    private fun findUser() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getSearchUsers(query)
        client.enqueue(object : Callback<GithubResponse> {
            override fun onResponse(
                call: Call<GithubResponse>,
                response: Response<GithubResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listUser.value = response.body()?.items as List<ItemsItem>?
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun searchUser(query: String) {
        if (query.isEmpty()) {
            _isLoading.value = true
            val client = ApiConfig.getApiService().getSearchUsers(Companion.query)
            client.enqueue(object : Callback<GithubResponse> {
                override fun onResponse(
                    call: Call<GithubResponse>,
                    response: Response<GithubResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _listUser.value = response.body()?.items as List<ItemsItem>?
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                    _isLoading.value = false
                    Log.e(TAG, "onFailure: ${t.message.toString()}")
                }
            })
        } else {
            _isLoading.value = true
            val client = ApiConfig.getApiService().getSearchUsers(query)
            client.enqueue(object : Callback<GithubResponse> {
                override fun onResponse(
                    call: Call<GithubResponse>,
                    response: Response<GithubResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _listUser.value = response.body()?.items as List<ItemsItem>?
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                    _isLoading.value = false
                    Log.e(TAG, "onFailure: ${t.message.toString()}")
                }
            })
        }
    }
}




