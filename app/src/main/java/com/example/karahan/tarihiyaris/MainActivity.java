package com.example.karahan.tarihiyaris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private GoogleApiClient mGoogleApiClient;
    Button sgo;
    TextView txt;
    ImageView img;
    Button normLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser usrr=FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        sgo=(Button) findViewById(R.id.btnCikis);
        sgo.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                int i = v.getId();
                if (i == R.id.btnCikis) {


                    mAuth.signOut();
                    startActivity(new Intent(MainActivity.this, LogIn.class));
                    finish();
                }
                if (i == R.id.btnOnlineYaris) {
                    Intent t = new Intent(getBaseContext(), onlineyaris.class);
                    startActivity(t);
                    //  finish();
                }

            }
        });
    }

            public void BtnProfile(View view) {
                // düğmeye yanıt verecek bir şeyler
                Intent i = new Intent(getBaseContext(), profile.class);

                startActivity(i);

            }
    public void btnOnlineTarih(View view) {
        // düğmeye yanıt verecek bir şeyler
        Intent i = new Intent(getBaseContext(), onlineyaris.class);

        startActivity(i);

    }
    public void btnRastgele(View view) {
        // düğmeye yanıt verecek bir şeyler
        Intent i = new Intent(getBaseContext(), offlineyaris.class);

        startActivity(i);

    }
    public void btnAbout(View view) {
        // düğmeye yanıt verecek bir şeyler
        Intent i = new Intent(getBaseContext(), hakkimizda.class);

        startActivity(i);

    }
        }

