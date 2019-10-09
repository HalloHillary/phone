package com.example.tan;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView LoadingView=findViewById(R.id.iv_loading);
       Animation animation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.splash_loading);
       animation.setFillAfter(true);

       animation.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {
           }
           @Override
           public void onAnimationEnd(Animation animation) {
               Intent intent=new Intent(SplashActivity.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
           @Override
           public void onAnimationRepeat(Animation animation) {

           }
       });
        LoadingView.startAnimation(animation);
    }
}
