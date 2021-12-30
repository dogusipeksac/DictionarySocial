package com.example.dictionarysocial.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dictionarysocial.MainActivity;
import com.example.dictionarysocial.Model.Post;
import com.example.dictionarysocial.R;
import com.example.dictionarysocial.Service.Firebase.Authentication;

import java.util.ArrayList;


public class FragmentHome extends Fragment {
    private RecyclerView recyclerView;
    private TextView no_post_tv;
    private ArrayList<Post> postList;
    private ImageView exit_app_image;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.post_recyclerview_home);
        no_post_tv=view.findViewById(R.id.no_post_tv);
        exit_app_image=view.findViewById(R.id.exit_app_image);
        postList=new ArrayList<>();


        if(postList.isEmpty()){
            no_post_tv.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
        else{
            no_post_tv.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        exit_app_image.setOnClickListener(v -> {
            Authentication.get(getContext()).signOut();
            Intent intent=new Intent(getContext(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        return view;
    }
}