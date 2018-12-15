package com.example.karahan.tarihiyaris;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "login";
    private FirebaseAuth.AuthStateListener mAuthListener;
    public GoogleApiClient mGoogleApiClient;
    TextView tvname;
    EditText mail;
    EditText pass;
    Button sgo;
    private ProgressDialog PD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //burası aslında before main olcaktı ama değiştiremedim şu lanet astudiodan dolayı.
        sgo=findViewById(R.id.btnGirisYap);
        mail=findViewById(R.id.txtMail);
        pass=findViewById(R.id.txtPass);
        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        mAuth = FirebaseAuth.getInstance();
        sgo.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View view) {
                final String email = mail.getText().toString();
                final String password = pass.getText().toString();

                try {

                    if (password.length() > 0 && email.length() > 0) {
                        PD.show();
                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                                    @Override

                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(
                                                    LogIn.this,
                                                    "Kimlik Hatası E-mail Veya Şifreniz Yanlış!",
                                                    Toast.LENGTH_LONG).show();

                                        } else {
                                            //burda resim varsa veya databasedeki diğer kayıtlı bilgileri al.. birde neey diye ses koy
                                            //önceden giriş yaptıysa direk mainactivity açık olarak gelsin
                                            Intent intent = new Intent(LogIn.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                        PD.dismiss();
                                    }
                                });
                    } else {
                        Toast.makeText(
                                LogIn.this,
                                "Bütün Alanlar Doldurulmalı",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    public String getdata(){
        String name = null;

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            name = user.getEmail();
            //  String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
        }

        return name;

    }
    public void btnmainpage(View view) {
        Intent i = new Intent(getBaseContext(), MainActivity.class);

        startActivity(i);
        finish();

    }
    public void btnkayitol(View view) {
        Intent i = new Intent(getBaseContext(), kayit.class);

        startActivity(i);
        //finish();

    }
}
