package com.example.democontentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.example.democontentprovider.model.Message;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.democontentprovider.DanhBa;
import com.example.democontentprovider.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TinNhan extends AppCompatActivity {
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;

    ListView lvTinNhan;
    ImageView bk;
    ArrayList<Message> dsTinNhan;
    ArrayAdapter<Message> adapterTinNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tin_nhan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bk=findViewById(R.id.back);
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TinNhan.this,MainActivity.class);
                //intent.setClassName("com.example.democontentprovider","com.example.democontentprovider.Danhba");
                startActivity(intent);
            }
        });
        addControls();
        showAllMessagesFromDevice();
    }

private void showAllMessagesFromDevice() {
    Uri uri = Uri.parse("content://sms/inbox"); // URI của tin nhắn trong hộp thư đến
    Cursor cursor = getContentResolver().query(uri, null, null, null,  null);
        dsTinNhan.clear();

        while (cursor.moveToNext()) {

            String addressColumn = "address";
            String bodyColumn = "body";
            String tenCotDate = "date";

            int addressIndex = cursor.getColumnIndex(addressColumn);
            int bodyIndex = cursor.getColumnIndex(bodyColumn);
            int dateIndex = cursor.getColumnIndex(tenCotDate);




            String address = cursor.getString(addressIndex); // Số điện thoại
            String noidung = cursor.getString(bodyIndex); // Nội dung tin nhắn
            long dateLong = cursor.getLong(dateIndex); // Lấy ngày dạng long

            // Chuyển đổi ngày từ long sang định dạng dễ đọc
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String ng = dateFormat.format(new Date(dateLong));

            Message message = new Message(address,ng, noidung); // Tạo một đối tượng tin nhắn
            dsTinNhan.add(message); // Thêm tin nhắn vào danh sách
        }

        cursor.close();

        adapterTinNhan.notifyDataSetChanged();

}


    private void addControls(){
        lvTinNhan=findViewById(R.id.lvTinNhan);
        lvTinNhan.setDividerHeight(16);
        dsTinNhan= new ArrayList<>();
        adapterTinNhan=new ArrayAdapter<>(TinNhan.this, android.R.layout.simple_list_item_1,dsTinNhan);
        lvTinNhan.setAdapter(adapterTinNhan);

    }
}