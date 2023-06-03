package com.example.kenneth_dela_cruz_android_developer;

import static android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    Animation TopAnim, BottomAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.setStatusBarColor(Color.parseColor("#FEF5AC"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            this.getWindow().getDecorView().getWindowInsetsController().setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS);
        } else {
            window.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.setStatusBarColor(Color.parseColor("#e28743"));
        }

        //animation
        TopAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        BottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        image = findViewById(R.id.imageView2);
        //  logo= findViewById(R.id.textView);

        image.setAnimation(TopAnim);

    }

    @Override
    protected void onStart() {
        super.onStart();
        transition();
    }

    private void transition(){

        Thread mSplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(3000);
                    }
                } catch (InterruptedException ignored) {
                }

                finish();
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, Login.class);
                startActivity(intent);
                overridePendingTransition(R.drawable.fade_in, R.drawable.fade_out);
            }
        };
        mSplashThread.start();
    }
}