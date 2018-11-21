package com.example.elisios.detalhesdousuarioapp.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseUser {

    @SerializedName("results")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
