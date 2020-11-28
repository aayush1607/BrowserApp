package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class userprofile extends AppCompatActivity {

    TextInputLayout fullname ,username,password;
    TextView fullnameLabel,usernameLabel;
    Button browse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        fullname=findViewById(R.id.full_name_profile);
        username=findViewById(R.id.username_profile);
        password=findViewById(R.id.password);
        fullnameLabel=findViewById(R.id.full_name_label);
        usernameLabel=findViewById(R.id.username_label);
        browse=findViewById(R.id.browse);
        showAllUserData();
        browse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(userprofile.this, MainBrowse.class);
                startActivity(intent);
                setContentView(R.layout.activity_main_browse);
            }
        });


    }

    private void showAllUserData() {

        Intent intent = getIntent();
        String user_name=intent.getStringExtra("name");
        String user_username=intent.getStringExtra("username");
        String user_password=intent.getStringExtra("password");

        fullnameLabel.setText(user_name);
        usernameLabel.setText(user_username);
        fullname.getEditText().setText(user_name);
        username.getEditText().setText(user_username);
        password.getEditText().setText(user_password);

    }

}