package com.example.dictionarysocial.Service.Firebase.LocalJson;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonService {
    private static JsonService jsonService;
    private static Context context;
    private ArrayList<String> list;
    //singleton
    public static JsonService get(Context context){
        if (jsonService==null){
            jsonService=new JsonService(context);
        }
        return jsonService;
    }
    private JsonService(Context context) {
        this.context = context;
        list=new ArrayList<>();
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
        try {
            JSONObject obj =(JSONObject) new JSONObject(loadJSONFromAsset("language.json"));
            JSONArray jsonArrayList= obj.getJSONArray("Language");

            for(int i=0;i<jsonArrayList.length();i++){
                JSONObject object=jsonArrayList.getJSONObject(i);
                String objectItem=object.getString("name");
                list.add(objectItem);
            }

            // for
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
