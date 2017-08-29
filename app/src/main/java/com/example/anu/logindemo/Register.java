package com.example.anu.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{
    Button btn_signup;
    EditText et_name, et_address, et_contact, et_username,et_email, et_password;
    TextView tv_signup, tv_name, tv_address, tv_contact, tv_username, tv_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_signup=(Button)findViewById(R.id.btn3);
        tv_signup=(TextView)findViewById(R.id.tv_signup);

        et_name=(EditText)findViewById(R.id.etName);
        et_address=(EditText)findViewById(R.id.etAddress);
        et_contact=(EditText)findViewById(R.id.etContact);
        et_username=(EditText)findViewById(R.id.etUsername);
        et_password=(EditText)findViewById(R.id.etPassword);
        et_email=(EditText)findViewById(R.id.etEmail);

        btn_signup.setOnClickListener(this);
        tv_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btn_signup){
            Intent intent=new Intent(Register.this, ShowingRegisteredData.class);
            intent.putExtra("Name", et_name.getText().toString());
            intent.putExtra("Address", et_address.getText().toString());
            intent.putExtra("Email", et_email.getText().toString());
            intent.putExtra("Contact", et_contact.getText().toString());
            intent.putExtra("Username", et_username.getText().toString());
            intent.putExtra("Password", et_password.getText().toString());
            startActivity(intent);
        }
        if(v==tv_signup){
            Toast.makeText(Register.this, "You have already registered.", Toast.LENGTH_SHORT).show();
        }
    }
}
