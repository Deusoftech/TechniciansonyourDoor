package com.example.techniciansonyourdoor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
private TextView test_view1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        test_view1=view.findViewById(R.id.desc);
        TextView test_view2=view.findViewById(R.id.common_prob);
        TextView test_view3=view.findViewById(R.id.report);
        TextView test_view4=view.findViewById(R.id.learn);
        Button test_view5=view.findViewById(R.id.btn_lang);


        test_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          Intent intent = new Intent(getActivity(),Definition.class);
          startActivity(intent);
            }
        });
        test_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Common_Problems.class);
                startActivity(intent);
            }
        });
        test_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Report_Problem.class);
                startActivity(intent);
            }
        });
        test_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Learn_More.class);
                startActivity(intent);
            }
        });

        test_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Language.class);
                startActivity(intent);
            }
        });

        return view;

    }

}