package com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitFaceDetectionApp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;

import java.util.List;

public class MainFaceDetectionActivity extends AppCompatActivity {
    private final static int REQUEST_IMAGE_CAPTURE = 124;
    Button openCameraButton;
    ImageView capturedImageView;
    
    InputImage  firebaseVision;
    FaceDetector visionFaceDetector;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_face_detection);
        
        openCameraButton = findViewById(R.id.openCameraButton);
        capturedImageView = findViewById(R.id.capturedImageView);

        FirebaseApp.initializeApp(this);
        openCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFile();
            }
        });
        Toast.makeText(this, "App is started", Toast.LENGTH_SHORT).show();
    }
    
    private void openFile(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        Bundle bundle = data.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");

        processFaceDetection(bitmap);
        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
    }

    private void processFaceDetection(Bitmap bitmap) {
        final StringBuilder stringBuilder = new StringBuilder();

        BitmapDrawable bitmapDrawable = (BitmapDrawable) capturedImageView.getDrawable();
        InputImage inputImage = InputImage.fromBitmap(bitmap, 0);
        FaceDetectorOptions faceDetectorOptions = new FaceDetectorOptions.Builder()
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                .enableTracking().build();
        
        FaceDetector faceDetector = FaceDetection.getClient(faceDetectorOptions);
        Task<List<Face>> result = faceDetector.process(inputImage);
        result.addOnSuccessListener(new OnSuccessListener<List<Face>>() {
            @Override
            public void onSuccess(List<Face> faces) {
                if (faces.size() != 0){
                    if (faces.size() == 1){
                        stringBuilder.append(faces.size() +" Face detected\n\n");
                    } else if (faces.size() > 1){
                        stringBuilder.append(faces.size() +" Faces detected\n\n");
                    }
                }
                
                for (Face face:faces){
                    int id = face.getTrackingId();
                    float rotationY = face.getHeadEulerAngleY();
                    float rotationZ = face.getHeadEulerAngleZ();
                    
                    stringBuilder.append("1. Face Traking Id ["+id+"]\n");
                    stringBuilder.append("2. Head Rotation to right ["+rotationY+"]\n");
                    stringBuilder.append("3. Head Tilted to sideways ["+rotationZ+"]\n");
                    
                    if (face.getSmilingProbability() > 0){
                        float smilingProbability = face.getSmilingProbability();
                        stringBuilder.append("4. Smilling probablility ["+smilingProbability+"]\n");
                    }

                    if (face.getLeftEyeOpenProbability() > 0){
                        float leftEyeProb = face.getLeftEyeOpenProbability();
                        stringBuilder.append("4. Left Eye open probablility ["+leftEyeProb+"]\n");
                    }

                    if (face.getRightEyeOpenProbability() > 0){
                        float rightEyeProb = face.getRightEyeOpenProbability();
                        stringBuilder.append("4. Right Eye open probablility ["+rightEyeProb+"]\n");
                    }
                    stringBuilder.append("\n");
                    
                }
                showDetection("Face Detection", stringBuilder, true);
                
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Sorry!! There is an error!");
                showDetection("Face Detection", stringBuilder1, false);
            }
        });
    }

    private void showDetection(final String title,final StringBuilder builder, boolean success) {
        if (success == true){
            if (builder.length() != 0){
                if (title.substring(0, title.indexOf(' ')).equalsIgnoreCase("OCR")){
                    
                }
            }
        }
    }
}