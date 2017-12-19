package com.example.leonardo.prova2.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.leonardo.prova2.R;
import com.example.leonardo.prova2.socF.SocFActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 2 seconds
                Intent abreLogin = new Intent(SplashScreenActivity.this, SocFActivity.class);
                startActivity(abreLogin);
                finish();
            }
        }, 2000);
    }
}
