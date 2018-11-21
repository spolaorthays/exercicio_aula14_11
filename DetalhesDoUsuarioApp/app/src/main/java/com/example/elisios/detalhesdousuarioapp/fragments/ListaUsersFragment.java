package com.example.elisios.detalhesdousuarioapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.elisios.detalhesdousuarioapp.R;
import com.example.elisios.detalhesdousuarioapp.adapter.RecyclerViewUserAdapter;
import com.example.elisios.detalhesdousuarioapp.interfaces.RecyclerListenerUser;
import com.example.elisios.detalhesdousuarioapp.interfaces.UserListener;
import com.example.elisios.detalhesdousuarioapp.model.ResponseUsersDAO;
import com.example.elisios.detalhesdousuarioapp.pojo.ResponseUser;
import com.example.elisios.detalhesdousuarioapp.pojo.User;
import com.example.elisios.detalhesdousuarioapp.service.ServiceUserListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaUsersFragment extends Fragment implements RecyclerListenerUser, ServiceUserListener {

    private RecyclerView recyclerView;
    private RecyclerViewUserAdapter adapter;
    private UserListener listener;
    private List<User> userList;

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

        ResponseUsersDAO usersDAO = new ResponseUsersDAO();

        userList = usersDAO.getUsersCall(this);

        createRecycler(userList);

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

    @Override
    public void onSucess(Object object) {
        userList = (List<User>) object;
        adapter.addUserList(userList);
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(getContext(),throwable.getMessage(),Toast.LENGTH_LONG).show();
    }
}
