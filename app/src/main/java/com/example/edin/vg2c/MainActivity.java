package com.example.edin.vg2c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);


//        ParseUser.logInInBackground("username", "password", new LogInCallback() {
//            @Override
//            public void done(ParseUser user, com.parse.ParseException e) {
//            }
//            public void done(ParseUser user, ParseException e) {
//                if (user != null) {
//                    Intent diger = new Intent(MainActivity.this, Main3Activity.class);
//                    startActivity(diger);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Tekrar deneyiniz!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equalsIgnoreCase("a") && password.getText().toString().equalsIgnoreCase("a")){
                    Intent diger = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(diger);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Tekrar deneyiniz!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}