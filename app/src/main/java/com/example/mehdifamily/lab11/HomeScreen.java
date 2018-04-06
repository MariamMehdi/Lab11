package com.example.mehdifamily.lab11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        TextView txt = (TextView)findViewById(R.id.txtName);
        final SharedPreferences sharedPreferences = getSharedPreferences("Login Details", MODE_PRIVATE);
        if(sharedPreferences!=null)
        {
            String value = sharedPreferences.getString("UserName","");
            txt.setText(value);
        }
        Button logout = (Button)findViewById(R.id.logoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("UserName","");
                editor.putString("Password","");
                editor.commit();
                Intent i = new Intent(HomeScreen.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
