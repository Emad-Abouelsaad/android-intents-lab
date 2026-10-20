package pl.edu.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        tvMessage.setText(message);

        btnBack.setOnClickListener(v -> finish());
    }
}
