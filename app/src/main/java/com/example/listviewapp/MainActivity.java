package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private List<String> names = new ArrayList<>();
    {
        names.add("Aliyah");
        names.add("Mikael");
    }
    Button add;
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.button);
        nameInput = (EditText) findViewById(R.id.nameInput);
        ListView listView = findViewById(R.id.list_item);

        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.item_layout, R.id.nameView, names);
        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Input name first!", Toast.LENGTH_SHORT).show();
                } else{
                    names.add(nameInput.getText().toString());
                    listView.setAdapter(adapter);
                    ListView listView = findViewById(R.id.list_item);
                }
            }
        });
    }
}