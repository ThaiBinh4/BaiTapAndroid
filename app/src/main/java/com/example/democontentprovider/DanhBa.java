package com.example.democontentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.democontentprovider.model.Contact;

import java.util.ArrayList;
import java.util.Currency;

public class DanhBa extends AppCompatActivity {
    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;
    ImageView bk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_ba);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bk=findViewById(R.id.back);
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhBa.this,MainActivity.class);
                //intent.setClassName("com.example.democontentprovider","com.example.democontentprovider.Danhba");
                startActivity(intent);
            }
        });
        addControls();
        showAllContactFromDevice();
    }
    private void showAllContactFromDevice(){
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor= getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            String tenCotName= ContactsContract.Contacts.DISPLAY_NAME;
            String tenCotPhone= ContactsContract.CommonDataKinds.Phone.NUMBER;
            int viTriCotName= cursor.getColumnIndex(tenCotName);
            int viTriCotPhone= cursor.getColumnIndex(tenCotPhone);
            String name =cursor.getString(viTriCotName);
            String phone=cursor.getString(viTriCotPhone);
            Contact contact= new Contact(name,phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();

        }
    }

    private void addControls(){
        lvDanhBa=findViewById(R.id.lvDanhBa);
        dsDanhBa= new ArrayList<>();
        adapterDanhBa=new ArrayAdapter<>(DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);

    }
}