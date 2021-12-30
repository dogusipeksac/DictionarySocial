package com.example.dictionarysocial.Service.Firebase.LocalJson;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

public class JsonService {
    private static JsonService jsonService;
    private static Context context;
    private ArrayList<String> languageList;
    private ArrayList<String> levelList;
    private String languageJson="language.json";
    private String languageLevelJson="language_level.json";

    //singleton
    public static JsonService get(Context context){
        if (jsonService==null){
            jsonService=new JsonService(context);
        }
        return jsonService;
    }
    private JsonService(Context context) {
        this.context = context;


    }

    //local json için yol
    public static String loadJSONFromAsset(String path) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    public ArrayList<String> getJsonFileFromLocallyData() {
        languageList=new ArrayList<>();
        try {
            JSONObject obj =new JSONObject(Objects.requireNonNull(loadJSONFromAsset(languageJson)));
            JSONArray jsonArrayList= obj.getJSONArray("Language");

            for(int i=0;i<jsonArrayList.length();i++){
                JSONObject object=jsonArrayList.getJSONObject(i);
                String objectItem=object.getString("name");
                languageList.add(objectItem);
            }

            // for
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return languageList;
    }
    public ArrayList<String> getJsonFileFromLocallyDataLevel(){
        levelList=new ArrayList<>();
        try {
            JSONObject obj =new JSONObject(Objects.requireNonNull(loadJSONFromAsset(languageLevelJson)));
            JSONArray jsonArrayList= obj.getJSONArray("Language_level");

            for(int i=0;i<jsonArrayList.length();i++){
                JSONObject object=jsonArrayList.getJSONObject(i);
                String objectItem=object.getString("level");
                levelList.add(objectItem);
            }

            // for
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return levelList;
    }

}
