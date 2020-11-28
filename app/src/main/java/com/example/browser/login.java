package com.example.browser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    TextInputLayout username,password;
    Button callSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callSignUp=findViewById(R.id.sign_up_screen);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
    callSignUp.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent intent=new Intent(login.this,SignUp.class);
            startActivity(intent);
        }
    });

    }




    private Boolean validateUser() {

        String val = username.getEditText().getText().toString();

        if(val.isEmpty())
        {
            username.setError("Field Empty");
            return false;

        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePass() {

        String val =password.getEditText().getText().toString();

        if(val.isEmpty())
        {
            username.setError("Field Empty");
            return false;

        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }


    public void loginUser(View view)
    {
        if(!validateUser() || !validatePass())
        {
            return;
        }
        else{
            isUser();
        }
    }

    private void isUser()
    {
        String userEnteredUsername= username.getEditText().getText().toString().trim();
        String userEnteredPassword= password.getEditText().getText().toString().trim();


        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");

        Query checkUser=reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists())
                {
                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB= snapshot.child(userEnteredUsername).child("pass").getValue(String.class);


                    if(passwordFromDB.equals(userEnteredPassword))
                    {
                        password.setError(null);
                        password.setErrorEnabled(false);

                        String nameFromDB= snapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB= snapshot.child(userEnteredUsername).child("username").getValue(String.class);

                        Intent intent =new Intent(getApplicationContext(),userprofile.class);

                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("password",passwordFromDB);

                        startActivity(intent);


                    }

                    else{
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                }

                else{
                    username.setError("No such User");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}