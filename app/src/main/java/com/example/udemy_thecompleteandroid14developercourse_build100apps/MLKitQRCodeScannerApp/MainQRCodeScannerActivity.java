package com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitQRCodeScannerApp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.util.Size;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainQRCodeScannerActivity extends AppCompatActivity {

    private ListenableFuture cameraProviderFuture;
    private ExecutorService cameraExecutor;
    private PreviewView previewView;
    private ImageAnalyzer imageAnalyzer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_qrcode_scanner);
        
        previewView = findViewById(R.id.previewView);
        this.getWindow().setFlags(1024, 1024);
        
        cameraExecutor = Executors.newSingleThreadExecutor();
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        imageAnalyzer = new ImageAnalyzer(getSupportFragmentManager());
        
        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try{
                    if (ActivityCompat.checkSelfPermission(MainQRCodeScannerActivity.this,
                            Manifest.permission.CAMERA) != (PackageManager.PERMISSION_GRANTED)){
                        ActivityCompat.requestPermissions(MainQRCodeScannerActivity.this, 
                                new String[]{Manifest.permission.CAMERA}, 101);
                    } else {
                        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) cameraProviderFuture.get();
                        bindPreview(processCameraProvider);
                    }
                } catch(ExecutionException e){
                    e.printStackTrace();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, ContextCompat.getMainExecutor(this));
        
        
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101 && grantResults.length > 0){
            ProcessCameraProvider processCameraProvider = null;
            try {
                processCameraProvider = (ProcessCameraProvider) cameraProviderFuture.get();
                
            } catch (ExecutionException e){
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            bindPreview(processCameraProvider);
        }
    }
    
    private void bindPreview(ProcessCameraProvider processCameraProvider){
        Preview preview = new Preview.Builder().build();
        CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        ImageCapture imageCapture = new ImageCapture.Builder().build();
        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder().
                setTargetResolution(new Size(1200, 720))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build();
        
        imageAnalysis.setAnalyzer(cameraExecutor, imageAnalyzer);
        processCameraProvider.unbindAll();
        processCameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture, imageAnalysis);
        
        
    }

    public class ImageAnalyzer implements ImageAnalysis.Analyzer{
        
        private FragmentManager fragmentManager;
        private BottomDialog bottomDialog;
        
        
        public ImageAnalyzer(FragmentManager supportFragmentManager) {
            this.fragmentManager = getSupportFragmentManager();
            bottomDialog = new BottomDialog();
        }

        @Override
        public void analyze(@NonNull ImageProxy image) {
            scanBarCode(image);
        }
        
        private void scanBarCode(ImageProxy image){
            @SuppressLint("UnsafeOptInUsageError")Image image1 = image.getImage();
            
            assert image1 != null;
            InputImage inputImage = InputImage.fromMediaImage(image1, image.getImageInfo().getRotationDegrees());

            BarcodeScannerOptions barcodeScannerOptions = new BarcodeScannerOptions.Builder()
                    .setBarcodeFormats(
                            Barcode.FORMAT_QR_CODE,
                            Barcode.FORMAT_AZTEC)
                    .build();

            BarcodeScanner barcodeScanner = BarcodeScanning.getClient(barcodeScannerOptions);
            Task<List<Barcode>> result = barcodeScanner.process(inputImage).addOnSuccessListener(new OnSuccessListener<List<Barcode>>() {
                @Override
                public void onSuccess(List<Barcode> barcodes) {
                    readerBarCodeData(barcodes);    
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainQRCodeScannerActivity.this, "Failed to read code", Toast.LENGTH_SHORT).show();
                }
            }).addOnCompleteListener(new OnCompleteListener<List<Barcode>>() {
                @Override
                public void onComplete(@NonNull Task<List<Barcode>> task) {
                    image.close();
                    
                }
            });
            
        }

        private void readerBarCodeData(List<Barcode> barcodes) {
            for (Barcode barcode: barcodes){
                Rect bounds = barcode.getBoundingBox();
                Point[]  corners = barcode.getCornerPoints();
                String rawValue = barcode.getRawValue();
                int valueType = barcode.getValueType();
                
                switch(valueType){
                    case Barcode.TYPE_WIFI:
                        String ssid = barcode.getWifi().getSsid();
                        String password = barcode.getWifi().getPassword();
                        int type = barcode.getWifi().getEncryptionType();
                        break;
                    case Barcode.TYPE_URL:
                        if (!bottomDialog.isAdded()){
                            bottomDialog.show(fragmentManager, "");
                        }
                        bottomDialog.fetchUrl(barcode.getUrl().getUrl());
                        String title = barcode.getUrl().getTitle();
                        String url = barcode.getUrl().getUrl();
                        break;
                    
                }
            }
        }
    }
}