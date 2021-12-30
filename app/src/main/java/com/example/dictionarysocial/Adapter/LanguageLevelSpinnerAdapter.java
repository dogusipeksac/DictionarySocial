package com.example.dictionarysocial.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dictionarysocial.R;

import java.util.ArrayList;

public class LanguageLevelSpinnerAdapter extends ArrayAdapter<String> {

    public LanguageLevelSpinnerAdapter(Context context, ArrayList<String> languageArrayList) {
        super(context, 0,languageArrayList);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position,
                                @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }
    private View initView(int position,View convertView,ViewGroup parent){
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.language_level_spinner_item,
                    parent,false);
        }
        TextView textViewTitle=convertView.findViewById(R.id.level_spinner_title);
        String languageItem=getItem(position);
        if(languageItem!=null){
            textViewTitle.setText(languageItem);
        }

        return convertView;
    }
}
