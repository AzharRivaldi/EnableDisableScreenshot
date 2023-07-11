package com.azhar.enabledisabless;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;

public class MainActivity extends AppCompatActivity {

    AppCompatToggleButton toggleButton;
    AppCompatTextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        tvStatus = findViewById(R.id.tvStatus);

        tvStatus.setText("Screenshot is OFF");

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                tvStatus.setText("Screenshot is ON");
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                        WindowManager.LayoutParams.FLAG_SECURE);

                Toast.makeText(this, "Screenshot is ON", Toast.LENGTH_SHORT).show();
            } else {
                tvStatus.setText("Screenshot is OFF");
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);

                Toast.makeText(this, "Screenshot is OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }

}