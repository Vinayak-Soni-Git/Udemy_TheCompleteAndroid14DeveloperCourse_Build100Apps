package com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Activities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatGroup;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatGroupViewModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Adapters.GroupAdapter;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityGroupsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroupsActivity extends AppCompatActivity {

    private ArrayList<ChatGroup> chatGroupArrayList;
    private RecyclerView recyclerView;
    private GroupAdapter groupAdapter;
    private ActivityGroupsBinding binding;
    private ChatGroupViewModel viewModel;
    private Dialog chatGroupDialog;
    private FloatingActionButton addNewGroupFabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_groups);
        viewModel = new ViewModelProvider(this).get(ChatGroupViewModel.class);
        recyclerView = findViewById(R.id.chatGroupsRecyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getGroupList().observe(this, new Observer<List<ChatGroup>>() {
            @Override
            public void onChanged(List<ChatGroup> chatGroups) {
                chatGroupArrayList = new ArrayList<>();
                chatGroupArrayList.addAll(chatGroups);
                groupAdapter = new GroupAdapter(chatGroupArrayList);
                recyclerView.setAdapter(groupAdapter);

                groupAdapter.notifyDataSetChanged();

            }
        });
        recyclerView.setAdapter(groupAdapter);
        addNewGroupFabButton = findViewById(R.id.addGroupButton);
        addNewGroupFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        chatGroupDialog = new Dialog(this);
        chatGroupDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this)
                .inflate(R.layout.add_group_alert_layout, null);
        chatGroupDialog.setContentView(view);
        chatGroupDialog.show();
        Button addNewGroupButton = view.findViewById(R.id.createChatGroupButton);
        EditText newGroupNameEditText = view.findViewById(R.id.newGroupNameEditText);
        addNewGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = newGroupNameEditText.getText().toString();
                viewModel.createNewChatGroup(groupName);
                chatGroupDialog.dismiss();
            }
        });

    }
}