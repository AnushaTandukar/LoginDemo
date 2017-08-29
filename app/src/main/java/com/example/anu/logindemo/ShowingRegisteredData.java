package com.example.anu.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowingRegisteredData extends AppCompatActivity {
    TextView tv_name,tv_address,tv_contact,tv_username,tv_password,tv_email;
        String name,address,email,contact,username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_registered_data);
        tv_name=(TextView)findViewById(R.id.etName1);
        tv_address=(TextView)findViewById(R.id.etAddress1);
        tv_contact=(TextView)findViewById(R.id.etContact1);
        tv_email=(TextView)findViewById(R.id.etEmail1);
        tv_username=(TextView)findViewById(R.id.etUsername1);
        tv_password=(TextView)findViewById(R.id.etPassword1);

        Intent intent=getIntent();
         name= intent.getStringExtra("Name");
         address=intent.getStringExtra("Address");
         email=intent.getStringExtra("Email");
         contact=intent.getStringExtra("Contact");
         username=intent.getStringExtra("Username");
         password=intent.getStringExtra("Password");

        tv_name.setText(name);
        tv_email.setText(email);
        tv_password.setText(password);
        tv_address.setText(address);
        tv_contact.setText(contact);
        tv_username.setText(username);
    }
}
