package com.example.elisios.detalhesdousuarioapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elisios.detalhesdousuarioapp.R;
import com.example.elisios.detalhesdousuarioapp.interfaces.RecyclerListenerUser;
import com.example.elisios.detalhesdousuarioapp.pojo.User;

import java.util.List;

public class RecyclerViewUserAdapter extends RecyclerView.Adapter<RecyclerViewUserAdapter.ViewHolder> {

    private List<User> userList;
    private RecyclerListenerUser recyclerListenerUser;

    public RecyclerViewUserAdapter(List<User> userList, RecyclerListenerUser recyclerListenerUser) {
        this.userList = userList;
        this.recyclerListenerUser = recyclerListenerUser;
    }

    //Após criar o novo atributo não será mais necessário este construtor
    /*public RecyclerViewUserAdapter(List<User> userList) {
        this.userList = userList;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        User user = userList.get(position);
        viewHolder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView emailNaTela;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emailNaTela = itemView.findViewById(R.id.text_email_id);
        }

        public void bind (final User user){
            emailNaTela.setText(user.getEmail());
            emailNaTela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerListenerUser.onUserClicado(user);
                }
            });
        }
    }
}
