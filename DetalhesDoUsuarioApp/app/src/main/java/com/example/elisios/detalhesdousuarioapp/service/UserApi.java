package com.example.elisios.detalhesdousuarioapp.service;

import com.example.elisios.detalhesdousuarioapp.pojo.ResponseUser;
import com.example.elisios.detalhesdousuarioapp.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    @GET("/api/?results=5")
    Call<ResponseUser> getUsers();
}
