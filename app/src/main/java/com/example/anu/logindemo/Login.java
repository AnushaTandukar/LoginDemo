package com.example.anu.logindemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView tv_username1, tv_password1;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_username1=(TextView)findViewById(R.id.etUsername2);
        tv_password1=(TextView)findViewById(R.id.etPassword2);

        try {
            SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            String username = sharedPref.getString("username", null);
            String pass = sharedPref.getString("password", null);
//            if (username != null && pass != null) {
//                startActivity(new Intent(getApplicationContext(), Login.class));
//            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }

//        tv_username1.setText(username);
//        tv_password1.setText(password);

        Intent intent=getIntent();
        username=intent.getStringExtra("Username");
        password=intent.getStringExtra("Password");


        tv_password1.setText(password);
        tv_username1.setText(username);

    }
}
