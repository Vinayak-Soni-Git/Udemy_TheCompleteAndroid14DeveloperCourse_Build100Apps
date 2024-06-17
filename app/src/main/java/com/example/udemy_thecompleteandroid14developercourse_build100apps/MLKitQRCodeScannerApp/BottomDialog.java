package com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitQRCodeScannerApp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BottomDialog extends BottomSheetDialogFragment {
    
    private TextView title, link, buttonVisit;
    private ImageView closeImageView;
    private String fetchedUrl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.link_dialog, container, false);
        
        title = view.findViewById(R.id.titleTextView);
        buttonVisit = view.findViewById(R.id.visitTextView);
        closeImageView = view.findViewById(R.id.closeImageView);
        
        title.setText(fetchedUrl);
        
        buttonVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(fetchedUrl));
                startActivity(intent);
            }
        });
        
        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
    
    public void fetchUrl(String url){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                fetchedUrl = url;
            }
        });
    }
}
