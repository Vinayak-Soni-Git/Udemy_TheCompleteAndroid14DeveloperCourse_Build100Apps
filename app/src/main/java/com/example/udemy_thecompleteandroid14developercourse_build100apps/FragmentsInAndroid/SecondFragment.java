package com.example.udemy_thecompleteandroid14developercourse_build100apps.FragmentsInAndroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class SecondFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button button = view.findViewById(R.id.secondFragmentButton);
        TextView textView = view.findViewById(R.id.secondFragmentTextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Welcome to second fragment", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}