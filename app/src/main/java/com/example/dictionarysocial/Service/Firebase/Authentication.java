package com.example.dictionarysocial.Service.Firebase;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.dictionarysocial.HomeActivity;
import com.example.dictionarysocial.Service.Firebase.Dao.UserDao;
import com.example.dictionarysocial.Util.PasswordHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Authentication {
    private FirebaseAuth auth;
    private Context context;
    //data okumak için
    private FirebaseDatabase database;

    private boolean activityFinish;


    public Authentication(Context context) {
        this.auth =FirebaseAuth.getInstance();
        this.context=context;
        this.database=FirebaseDatabase.getInstance();

    }
    private static Authentication authentication;
    public static Authentication get(Context context){
        if (authentication==null){
            authentication=new Authentication(context);
        }
        return authentication;
    }


    public void register(String email,
                         String password,
                         String username) {
        String encryptionPassword= PasswordHelper.encrypt(password);
        assert encryptionPassword != null;
        auth.createUserWithEmailAndPassword(email,encryptionPassword)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        FirebaseUser firebaseUser=auth.getCurrentUser();
                        assert firebaseUser != null;
                        String user_id=firebaseUser.getUid();
                        UserDao.get(context).createUserHashMapDatabase(
                                email,
                                user_id,
                                username,
                                encryptionPassword,
                                "none",
                                "none",
                                "none",
                                "none");
                    }
                    else{
                        Toast.makeText(context, "You can't register with"+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
    public  void signOut(){
        FirebaseAuth.getInstance().signOut();
    }
    public void login(String email,
                      String password){
        String encryptionPassword=PasswordHelper.encrypt(password);
        assert encryptionPassword != null;
        auth.signInWithEmailAndPassword(email,encryptionPassword).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                DatabaseReference reference=database.getReference().child("Users")
                        .child(auth.getCurrentUser().getUid());
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Intent intent=new Intent(context,HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        setActivityFinish(true);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }else{
                Toast.makeText(context, "Authentication failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean isActivityFinish() {
        return activityFinish;
    }

    public void setActivityFinish(boolean activityFinish) {
        this.activityFinish = activityFinish;
    }
}
