package com.example.demobookrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class BookDetailActivity extends AppCompatActivity {
    private TextView bookName;
    private TextView bookPrice;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        bookName = findViewById(R.id.book_name);
        bookPrice = findViewById(R.id.book_price);
        bookImage = findViewById(R.id.book_image);

        // Get the data passed from the MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("BOOK_NAME");
        String price = intent.getStringExtra("BOOK_PRICE");
        String imageUrl = intent.getStringExtra("BOOK_IMAGE");

        bookName.setText(name);
        bookPrice.setText(price);

        // Load the image using a library like Glide or Picasso
        Glide.with(this).load(imageUrl).into(bookImage);
    }
}