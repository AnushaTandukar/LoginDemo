package com.example.anu.logindemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    TextView t1_username,t2_password;
    EditText e1_username,e2_password;
    Button btn_login,btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login=(Button)findViewById(R.id.btn1);
        btn_register=(Button)findViewById(R.id.btn2);
        e1_username=(EditText) findViewById(R.id.et_username);
        e2_password=(EditText)findViewById(R.id.et_password);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        try {
            SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            String username = sharedPref.getString("username", null);
            String pass = sharedPref.getString("password", null);
            if (username != null && pass != null) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btn_login) {
            if (e1_username.getText().toString().equals("") || e2_password.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "enter your name and pw", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent =new Intent(MainActivity.this, Login.class);
                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString("username", e1_username.getText().toString());
                editor.putString("password", e2_password.getText().toString());
                editor.apply();

                intent.putExtra("Username", e1_username.getText().toString());
                intent.putExtra("Password", e2_password.getText().toString());

                startActivity(intent);
//                Toast.makeText(MainActivity.this, "you are logged in!!", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent (MainActivity.this, login.class);

            }
//            else{
//                Intent intent=new Intent(MainActivity.this, Login.class);
//                intent.putExtra("Username", e1_username.getText().toString());
//                intent.putExtra("Password", e2_password.getText().toString());
//                startActivity(intent);
            }


        if(v==btn_register){
            Intent intent=new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        }
    }
}
