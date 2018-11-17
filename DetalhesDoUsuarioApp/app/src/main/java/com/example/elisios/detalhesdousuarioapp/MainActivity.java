package com.example.elisios.detalhesdousuarioapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.elisios.detalhesdousuarioapp.fragments.ListaUsersFragment;
import com.example.elisios.detalhesdousuarioapp.fragments.UserDetalheFragment;
import com.example.elisios.detalhesdousuarioapp.interfaces.UserListener;
import com.example.elisios.detalhesdousuarioapp.pojo.User;

public class MainActivity extends AppCompatActivity implements UserListener {

    public static final String OBJ_USER = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarListaUsers();
    }

    private void iniciarListaUsers(){
          ListaUsersFragment fragment = new ListaUsersFragment();
          setupFragments(fragment);
    }

   /* public void iniciarFragmentDetalheUser(){
        UserDetalheFragment fragment = new UserDetalheFragment();
        setupFragments(fragment);
    }*/

    public void setupFragments(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_layout_fragments_id, fragment);
        transaction.commit();
    }

    @Override
    public void iniciarFragmentDetalheUser(User user) {
        UserDetalheFragment userDetalheFragment = new UserDetalheFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(OBJ_USER, user);
        userDetalheFragment.setArguments(bundle);

        setupFragments(userDetalheFragment);
    }
}
