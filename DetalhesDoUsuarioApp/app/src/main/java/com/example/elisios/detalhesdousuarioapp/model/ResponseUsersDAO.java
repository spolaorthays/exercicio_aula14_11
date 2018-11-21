package com.example.elisios.detalhesdousuarioapp.model;

import android.content.Context;

import com.example.elisios.detalhesdousuarioapp.pojo.ResponseUser;
import com.example.elisios.detalhesdousuarioapp.pojo.User;
import com.example.elisios.detalhesdousuarioapp.service.RetrofitService;
import com.example.elisios.detalhesdousuarioapp.service.ServiceUserListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseUsersDAO {

    public List<User> getUsersCall (final ServiceUserListener listener) {

        Call<ResponseUser> call = RetrofitService.getApiService().getUsers();

        call.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if (response != null){
                    listener.onSucess(response.body().getUsers());
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                    listener.onError(t);
            }
        });

        return new ArrayList<>();
    }
}
