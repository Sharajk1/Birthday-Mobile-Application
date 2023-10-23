package com.example.birthdayreminder;
import android.database.Cursor;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
public class Delete_view extends AppCompatActivity {
    Button btndel, btnview ;
    dbManager DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delete);
        btnview = findViewById(R.id.view);
        btndel = findViewById(R.id.del);
        DB = new dbManager(this);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.readallreminders();
                if (res.getCount() == 0) {
                    Toast.makeText(Delete_view.this, "No entries exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Name:" + res.getString(0) + "\n");
                    buffer.append("DOB:" + res.getString(1) + "\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Delete_view.this);
                builder.setCancelable(true);
                builder.setTitle("Birthdays");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.dele();
            }
        });
    }
}
