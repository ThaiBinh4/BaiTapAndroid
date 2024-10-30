package com.example.democontentprovider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;

    ImageView img1,img2;
    private void addEvents() {
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoManHinhDanhBa();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyMoManHinhTinNhan();
            }
        });
    }
    private void xuLyMoManHinhDanhBa() {
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        //intent.setClassName("com.example.democontentprovider","com.example.democontentprovider.Danhba");
        startActivity(intent);
    }
    private void xulyMoManHinhTinNhan() {
        Intent intent = new Intent(MainActivity.this,TinNhan.class);
        //intent.setClassName("com.example.democontentprovider","com.example.democontentprovider.Danhba");
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        img1= findViewById(R.id.img1);
        img2= findViewById(R.id.img2);
        addEvents();
    }
}