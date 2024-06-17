package com.example.udemy_thecompleteandroid14developercourse_build100apps.FirebaseFirestoreDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainFirestoreDatabaseActivity extends AppCompatActivity {

    private Button saveButton, readButton, updateButton, deleteButton;
    private EditText nameEditText, emailEditText;
    private TextView resultTextView;

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private DocumentReference friendRef = firebaseFirestore.collection("Users")
            .document("Documents");
    private CollectionReference collectionReference = firebaseFirestore.collection("Users");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_firestore_database);

        saveButton = findViewById(R.id.saveButton);
        readButton = findViewById(R.id.readButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        resultTextView = findViewById(R.id.resultTextView);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToNewDocument();
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllDocumentsInCollection();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSpecificDocument();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
            }
        });


    }

    private void saveDataToNewDocument(){
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        Friend friend = new Friend(name, email);

        collectionReference.add(friend).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                String docId = documentReference.getId();

            }
        });
    }

    private void getAllDocumentsInCollection(){
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            String data = "";
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot snapshot: queryDocumentSnapshots){
                    Friend friend = snapshot.toObject(Friend.class);
                    data += friend.getName() + " " + friend.getEmail();
                }
                resultTextView.setText(data);
            }
        });
    }
    private void updateSpecificDocument(){
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        friendRef.update("name", name);
        friendRef.update("email", email);
    }

    private void deleteAll(){
        friendRef.delete();
    }
}