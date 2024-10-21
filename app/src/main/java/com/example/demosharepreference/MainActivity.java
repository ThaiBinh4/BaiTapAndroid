package com.example.demosharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView v1,v2,v3,v4,v5,v6;
    private TextView txtdiem,inf;
    private int diemso;
    private String tt;
    SharedPreferences sharedPreferences;

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

        sharedPreferences= getSharedPreferences("diem", MODE_PRIVATE);

        diemso = sharedPreferences.getInt("diemso", 0); // Lấy giá trị "diemso" từ SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("infor", "Đỗ Thái Bình msgitv 22115053122304");
        editor.commit();
        // Khởi tạo các nút và TextView
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        v4 = findViewById(R.id.v4);
        v5 = findViewById(R.id.v5);
        v6 = findViewById(R.id.v6);
        inf = findViewById(R.id.info);

        tt=sharedPreferences.getString("infor", "");
        inf.setText(tt);
        txtdiem = findViewById(R.id.diem);

        // Hiển thị điểm hiện tại khi khởi động
        txtdiem.setText("Điểm: " + diemso);

        // Khởi tạo sự kiện click
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diemso += 10;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("diemso", diemso);
                editor.commit();
                txtdiem.setText("Điểm: " + diemso); // Cập nhật TextView
            }
        };

        v1.setOnClickListener(listener);
        v2.setOnClickListener(listener);
        v3.setOnClickListener(listener);
        v4.setOnClickListener(listener);
        v5.setOnClickListener(listener);
        v6.setOnClickListener(listener);
    }
}
