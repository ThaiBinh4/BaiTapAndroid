package com.example.apptaplayoutandbottomnavigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    // khai báo các đối tượng tap

    TabLayout tabLayout;
    ViewPager viewPager;
    View mView;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView listView;
        listAdapter itemAdapter;
        List<items> itlist;
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        listView = mView.findViewById(R.id.listView);
        itlist = new ArrayList<>();
        itlist.add(new items("Ram kingdom 3", "Loại ram hiện đại mạnh mẽ ddr3 máy văn phòng", "ram.png",true));
        itlist.add(new items("Ram kingdom", "Loại ram hiện đại mạnh mẽ ddr4 hiệu suất vượt trội", "ram.png",true));
        itlist.add(new items("Chuột logitech k2", "chuột với phím bấm nhẹ nhàng ban khuya cho cảm giác tuyệt vời", "chuot.png",true));
        itlist.add(new items("Chuột logitech r3", "chuột hiện đại cảm giác tuyệt vời", "chuot.png",true));
        itlist.add(new items("Chuột logitech k5", "chuột chơi game tiếng click mượt mà", "chuot.png",true));
        itlist.add(new items("Chuột logitech l1", "chuột văn phòng nhẹ nhàng cho nữ", "chuot.png",true));
        itlist.add(new items("Chuột logitech h5", "chuột chuột gaming loại xịn bluetooth", "chuot.png",true));
        itlist.add(new items("Chuột logitech a1", "chuột có dây giá rẻ cho sinh viên", "chuot.png",true));

        itemAdapter = new listAdapter(getContext(), itlist);

        listView.setAdapter(itemAdapter);
        return mView;
    }
}