package com.example.pdfcreator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {

    private PDFView pdfView;

    Button btnPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pdfView = findViewById(R.id.pdfView);

        btnPrint = findViewById(R.id.btnPrint);

        // Get the PDF file path from the intent
        String filePath = getIntent().getStringExtra("PDF_PATH");

        // Load and display the PDF file
        pdfView.fromFile(new File(filePath))
                .enableSwipe(true) // Allows to swipe pages horizontally
                .load();

        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.dynamixsoftware.printershare");

                if (intent != null) {
                    // The app exists, so launch it
                    startActivity(intent);
                } else {
                    // The app doesn't exist on the device
                    Toast.makeText(MainActivity2.this, "App not installed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}