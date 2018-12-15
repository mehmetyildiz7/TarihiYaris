package com.example.karahan.tarihiyaris;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Random;

public class onlineyaris extends AppCompatActivity {
    TextView txt,txtSon;
    ImageButton a, b, c, d;
    int skor;
    String TAG = "ZAA";
    /*Iterable<DataSnapshot> soruList;*/
    ArrayList<DataSnapshot> soruList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlineyaris);
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        final FirebaseStorage storage = FirebaseStorage.getInstance();
        final StorageReference storageRef = storage.getReference();

        soruList = new ArrayList<>();

        a = findViewById(R.id.aSikki);
        b = findViewById(R.id.bSikki);
        c = findViewById(R.id.cSikki);
        d = findViewById(R.id.dSikki);
        txt = findViewById(R.id.txtSoru);
        txtSon=findViewById(R.id.txtSonraki);
        DatabaseReference ref = mDatabase.child("sorular");
        final ValueEventListener soruListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
//                soruList = dataSnapshot.getChildren();
                for(DataSnapshot d : dataSnapshot.getChildren())
                {
                    soruList.add(d);
                }

                Random r = new Random();
                int i = r.nextInt(16);

                sorular soru = soruList.get(i).getValue(sorular.class);
                txt.setText(soru.getSoru());
                StorageReference pathReference = storageRef.child(soru.getA());
                pathReference.getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        a.setImageBitmap(bitmap);
                    }
                });


                // Get Post object and use the values to update the UI
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());// ...
            }
        };


        ref.addValueEventListener(soruListener);
    }
}
