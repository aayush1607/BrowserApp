package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout name,username,pass;
    Button regBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button callLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        FirebaseApp.initializeApp(this);

        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        regBtn=findViewById(R.id.regbtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("users");

                //get all values
                String fname=name.getEditText().getText().toString();
                String uname=username.getEditText().getText().toString();
                String upass=pass.getEditText().getText().toString();


                UserHelperClass helperClass=new UserHelperClass(fname,uname,upass);
                reference.child(uname).setValue(helperClass);
                Context context = getApplicationContext();
                CharSequence text = "Signup Successful!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


        callLogin=findViewById(R.id.login_screen);

        callLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(SignUp.this,login.class);
                startActivity(intent);
            }
        });

    }
}