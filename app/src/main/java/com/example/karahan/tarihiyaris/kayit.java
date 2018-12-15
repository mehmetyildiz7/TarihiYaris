package com.example.karahan.tarihiyaris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;
import android.support.annotation.NonNull;
import android.app.ProgressDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class kayit extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    public EditText edtAd;
    public EditText edtsoyAd;
    public EditText edtMail;
    public EditText edtPassword;
    public  EditText edtRepassword;
    public Button btnkyt;
    private FirebaseAuth auth;
    private ProgressDialog PD;
    public static String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        PD = new ProgressDialog(kayit.this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);
        auth = FirebaseAuth.getInstance();
        edtAd = findViewById(R.id.txtMail);
        edtsoyAd = findViewById(R.id.txtPass);
        edtMail = findViewById(R.id.txtEmail);
        edtPassword = findViewById(R.id.txtPassword);
        btnkyt = findViewById(R.id.btnKaydiTamamla);
        edtRepassword = findViewById(R.id.txtRePassword);
        btnkyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtMail.getText().toString();
                final String password = edtPassword.getText().toString();
                final String pass = edtRepassword.getText().toString();
                final String ad = edtAd.getText().toString();
                final String soyad = edtsoyAd.getText().toString();


                try {
                    if (password.length() > 0 && email.length() > 0) {
                        if(pass.equals(password.toString()) ) {
                            PD.show();
                            auth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(kayit.this, new OnCompleteListener<AuthResult>() {
                                        @Override

                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (!task.isSuccessful()) {
                                                Toast.makeText(
                                                        kayit.this,
                                                        "Aynı Maille Birden Fazla Üyelik Açamazsın",
                                                        Toast.LENGTH_LONG).show();
                                            } else {

                                                FirebaseUser mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

                                                if (mCurrentUser != null) {
                                                    Toast.makeText(
                                                            kayit.this,
                                                            "Kayıt Başarıyla OLuşturuldu.",
                                                            Toast.LENGTH_LONG).show();

                                                    uid = mCurrentUser.getUid();
                                                    Users usrr = new Users(uid, ad, soyad, email, password);
                                                    FirebaseDatabase.getInstance().getReference().child("Users").child(uid).setValue(usrr);
                                                    Intent intent = new Intent(kayit.this, LogIn.class);
                                                    startActivity(intent);
                                                    finish();
                                                }

                                            }
                                            PD.dismiss();
                                        }

                                    });
                        }
                        else{
                            Toast.makeText(
                                    kayit.this,
                                    "Girdiğin Passwordleri ve Mail Biçimini kontrol et",
                                    Toast.LENGTH_LONG).show();

                        }


                    } else {
                        Toast.makeText(
                                kayit.this,
                                "Bütün Alanları Doldurunuz.",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

    }

    }
