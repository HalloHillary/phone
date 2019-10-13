package com.example.tan;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
 public class AdActivity extends AppCompatActivity {
     TextView tv_count;

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_ad);
         tv_count= findViewById(R.id.tv_count);

         new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i=5;i>=0;i--) {
                     SystemClock.sleep(1000);
                     final int count=i;
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             tv_count.setText("点击跳转" +count);
                         }
                     });
                 }
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         Intent intent=new Intent(AdActivity.this,MainActivity.class);
                         startActivity(intent);
                         finish();
                     }
                 });
             }
         }).start();
     }
 }

