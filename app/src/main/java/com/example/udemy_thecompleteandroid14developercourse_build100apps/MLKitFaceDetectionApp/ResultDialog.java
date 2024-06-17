package com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitFaceDetectionApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class ResultDialog extends DialogFragment {
    Button okButton;
    TextView detectionDialogTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.face_detection_result_layout, container, false);
        String text = "";
        okButton = view.findViewById(R.id.okButton);
        detectionDialogTextView = view.findViewById(R.id.detectionDialogTextView);
        
        Bundle bundle = getArguments();
        text = bundle.getString("RESULT_TEXT");
        detectionDialogTextView.setText(text);
        
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
}
