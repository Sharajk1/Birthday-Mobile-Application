package com.example.birthdayreminder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnadd,btnview;
    dbManager DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd=(Button)findViewById(R.id.btn_add);
        btnview=(Button)findViewById(R.id.btn_view);
        DB=new dbManager(this);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNext();
            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNext1();
            }
        });
    }
    public void openNext() {
        Intent intent = new Intent(this, addBirthday.class);
        startActivity(intent);
    }

    public void openNext1() {
        Intent intent = new Intent(this, Delete_view.class);
        startActivity(intent);
    }
}