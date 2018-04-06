package com.example.mehdifamily.lab11;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText txtuserName, txtpassword;
    Button btnJoin;
    SharedPreferences sharedPreferences;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtuserName= (EditText) findViewById(R.id.userName);
        txtpassword= (EditText) findViewById(R.id.password);
        btnJoin=(Button) findViewById(R.id.joinButton);

        context=LoginActivity.this;
        sharedPreferences=getSharedPreferences("Login Details", MODE_PRIVATE);

        if(savedInstanceState!=null){
            String value = sharedPreferences.getString("UserName","");
            if(value!=""){
                Intent i = new Intent(context,HomeScreen.class);
                startActivity(i);
                finish();
            }
        }
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= txtuserName.getText().toString();
                String password= txtpassword.getText().toString();

                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("UserName",username);
                    editor.putString("password",password);
                    editor.commit();
                    Intent i = new Intent(context,HomeScreen.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}


