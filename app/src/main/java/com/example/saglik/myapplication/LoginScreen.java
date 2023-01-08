package com.example.saglik.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    Button giris,uye;
    EditText kullanici,sifre;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        kullanici=findViewById(R.id.edt_account);
        sifre=findViewById(R.id.edt_password);

        giris=findViewById(R.id.btn_login);

        sp=getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor=sp.edit();


        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kullanici.getText().toString().equals("admin") && sifre.getText().toString().equals("123") )
                {
                    editor.putString("username",kullanici.getText().toString());
                    editor.putString("password",sifre.getText().toString());
                    editor.commit();

                    startActivity(new Intent(LoginScreen.this,HomeScreen.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Hatalı Girdiniz",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}