package pl.edu.intentexample;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenSecond = findViewById(R.id.btnOpenSecond);
        Button btnOpenWebsite = findViewById(R.id.btnOpenWebsite);
        Button btnShowLocation = findViewById(R.id.btnShowLocation);

        btnOpenSecond.setOnClickListener(v -> openSecondActivity());
        btnOpenWebsite.setOnClickListener(v -> openWebsite());
        btnShowLocation.setOnClickListener(v -> showLocation());
    }

    // Explicit intent - the target class is named directly
    private void openSecondActivity() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Message sent from MainActivity");
        startActivity(intent);
    }

    // Implicit intent - Android picks an app that can handle ACTION_VIEW for this URI
    private void openWebsite() {
        Uri uri = Uri.parse("https://www.android.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.no_browser, Toast.LENGTH_SHORT).show();
        }
    }

    private void showLocation() {
        Uri geoUri = Uri.parse("geo:50.3217,19.1949");
        Intent intent = new Intent(Intent.ACTION_VIEW, geoUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.no_map_app, Toast.LENGTH_SHORT).show();
        }
    }
}
