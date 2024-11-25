package com.example.apptaplayoutandbottomnavigation;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class listAdapter extends BaseAdapter {
    private Context context;
    private List<items> itemsList;

    public listAdapter(Context context, List<items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        // Ánh xạ các thành phần trong layout item.xml
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tenTextView = convertView.findViewById(R.id.ten);
        TextView moTaTextView = convertView.findViewById(R.id.mota);
        Button muaButton = convertView.findViewById(R.id.button);

        items currentItem = itemsList.get(position);

        tenTextView.setText(currentItem.getTen());
        moTaTextView.setText(currentItem.getTieude());

        int imageResId = R.drawable.picture; // Hình ảnh mặc định
        if (currentItem.getAnh().contains("chuot")) {
            imageResId = R.drawable.chuot; // Thay thế bằng tên ảnh cụ thể
        }
        if (currentItem.getAnh().contains("ram")) {
            imageResId = R.drawable.ram; // Thay thế bằng tên ảnh cụ thể
        }
        imageView.setImageResource(imageResId);


        muaButton.setOnClickListener(v -> {
            Toast.makeText(context, "Mua: " + currentItem.getTen(), Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }

}
