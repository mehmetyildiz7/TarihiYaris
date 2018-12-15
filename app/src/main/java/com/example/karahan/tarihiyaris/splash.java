package com.example.karahan.tarihiyaris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class splash extends Activity {
    private FirebaseAuth mAuth;
    ImageView sp;
    ImageView sp1;
    ImageView sp2;
    ImageView sp3;
    Animation frombottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAuth=FirebaseAuth.getInstance();

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    if(mAuth.getUid()!=null)
                    {
                        Intent intent = new Intent(splash.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(splash.this, LogIn.class);
                        startActivity(intent);
                    }

                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
