package com.example.dictionarysocial.Service.Firebase.Dao;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.dictionarysocial.HomeActivity;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private Context context;
    private FirebaseFirestore db;

    private static UserDao userDao;

    //singleton
    public static UserDao get(Context context){
        if (userDao==null){
            userDao=new UserDao(context);
        }
        return userDao;
    }

    public UserDao(Context context) {
        this.context = context;
        db=FirebaseFirestore.getInstance();
    }

    public void createUserHashMapDatabase(String email,
                                          String id,
                                          String username,
                                          String encryptionPassword,
                                          String imageUrl,
                                          String description,
                                          String language,
                                          String language_level){
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("email",email);
        user.put("username",username);
        user.put("encryptionPassword",encryptionPassword);
        user.put("imageUrl",imageUrl);
        user.put("description",description);
        user.put("language",language);
        user.put("language_level",language_level);
        db.collection("Users")
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    Intent intent=new Intent(context, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                })
                .addOnFailureListener(exception -> Toast.makeText(context, "You can't register because"+exception, Toast.LENGTH_SHORT).show());
    }
}
