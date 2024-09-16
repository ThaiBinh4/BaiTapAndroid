package com.example.constraintlayoutlogin;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    TextView thontin;
    EditText mail;
    EditText passw;
    Button btnlogin;
    Button btngg;
    Button btnfb;
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
         thontin =findViewById(R.id.inf);
        mail=findViewById(R.id.email);
        passw=findViewById(R.id.passw);
        btnlogin = findViewById(R.id.button);
        btngg=findViewById(R.id.button2);
        btngg.setBackgroundColor(Color.parseColor("#FFFFFF"));
        btnfb=findViewById(R.id.button3);
        btnfb.setBackgroundColor(Color.parseColor("#FFFFFF"));

        btnlogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.main), "Email: "+mail.getText() +"     Password: "+ passw.getText(), Snackbar.LENGTH_LONG).show();
                thontin.setText("Email: "+mail.getText() +"     Password: "+ passw.getText());
            }
        });

    }

}