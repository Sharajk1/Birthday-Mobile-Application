package com.example.birthdayreminder;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class notification_layout extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_layout);
            textView = findViewById(R.id.date);
        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.getString("message"));
    }
}