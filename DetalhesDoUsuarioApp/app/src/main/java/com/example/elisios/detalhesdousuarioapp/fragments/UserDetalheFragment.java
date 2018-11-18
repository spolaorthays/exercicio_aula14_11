package com.example.elisios.detalhesdousuarioapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elisios.detalhesdousuarioapp.MainActivity;
import com.example.elisios.detalhesdousuarioapp.R;
import com.example.elisios.detalhesdousuarioapp.interfaces.UserListener;
import com.example.elisios.detalhesdousuarioapp.pojo.User;

import static com.example.elisios.detalhesdousuarioapp.MainActivity.OBJ_USER;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetalheFragment extends Fragment {

    private User user;
    private TextView emailRequerido;
    private UserListener listener;


    public UserDetalheFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (UserListener) context;
        this.user = (User) getArguments().getSerializable(MainActivity.OBJ_USER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_detalhe, container, false);

        emailRequerido = view.findViewById(R.id.detail_email_id);
        setUser();

        return view;
    }

    private void setUser(){
        emailRequerido.setText(user.getEmail());
    }

}
