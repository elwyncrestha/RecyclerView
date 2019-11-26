package com.elvin.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.elvin.recyclerview.adapter.ContactAdapter;
import com.elvin.recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recyclerView);

        List<Contact> contacts = new ArrayList<Contact>() {
            {
                add(new Contact("Image 1", "Phone Number 1", R.drawable.one));
                add(new Contact("Image 2", "Phone Number 2", R.drawable.two));
                add(new Contact("Image 3", "Phone Number 3", R.drawable.three));
            }
        };

        ContactAdapter contactAdapter = new ContactAdapter(this, contacts);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
