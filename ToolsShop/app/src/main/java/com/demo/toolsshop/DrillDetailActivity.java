package com.demo.toolsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private ImageView image;
    private TextView textViewLogo;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        image = findViewById(R.id.imageViewDrill);
        textViewLogo = findViewById(R.id.textViewLogo);
        textViewInfo = findViewById(R.id.textViewInfo);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            textViewLogo.setText(title);
            textViewInfo.setText(info);
            image.setImageResource(resId);
        } else {
            Intent backToCategory =  new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }

    }
}
