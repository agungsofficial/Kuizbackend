package com.eostudio.kuizbackend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void klikLogin(View v) {
        Intent logintent = new Intent(this, MainActivity.class);
        startActivity(logintent);
    }
    public void klikDaftar(View v) {
        Intent signintent = new Intent(this, DaftarActivity.class);
        startActivity(signintent);
    }

}
