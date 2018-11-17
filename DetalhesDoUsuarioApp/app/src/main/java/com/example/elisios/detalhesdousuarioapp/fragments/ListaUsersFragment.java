package com.example.elisios.detalhesdousuarioapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elisios.detalhesdousuarioapp.R;
import com.example.elisios.detalhesdousuarioapp.adapter.RecyclerViewUserAdapter;
import com.example.elisios.detalhesdousuarioapp.interfaces.RecyclerListenerUser;
import com.example.elisios.detalhesdousuarioapp.interfaces.UserListener;
import com.example.elisios.detalhesdousuarioapp.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaUsersFragment extends Fragment implements RecyclerListenerUser {

    private RecyclerView recyclerView;
    private RecyclerViewUserAdapter adapter;
    private UserListener listener;

    public ListaUsersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (UserListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_users, container, false);

        recyclerView = view.findViewById(R.id.recycler_users_id);

        createRecycler(getUsersList());

        return view;
    }

    private void createRecycler (List<User> userList){
        //Coloca a lista dentro do recycler
        adapter = new RecyclerViewUserAdapter(userList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public List<User> getUsersList(){
        List<User> userList = new ArrayList<>();

        User user = new User();
        user.setEmail("thays@gmail.com");
        userList.add(user);

        User user2 = new User();
        user2.setEmail("fabi@gmail.com");
        userList.add(user2);

        User user3 = new User();
        user3.setEmail("luara@gmail.com");
        userList.add(user3);

        User user4 = new User();
        user4.setEmail("marcus@gmail.com");
        userList.add(user4);

        User user5 = new User();
        user5.setEmail("andreza@gmail.com");
        userList.add(user5);

        User user6 = new User();
        user6.setEmail("thiago@gmail.com");
        userList.add(user6);

        User user7 = new User();
        user7.setEmail("tati@gmail.com");
        userList.add(user7);

        return userList;
    }

    @Override
    public void onUserClicado(User user) {
        listener.iniciarFragmentDetalheUser(user);
    }
}
