package com.example.food3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView tvName, tvDescription, tvPrice;
    ImageView ivImage;
    Button btnOrder;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);
        tvDescription = findViewById(R.id.tvDescription);
        tvPrice = findViewById(R.id.tvPrice);
        ivImage = findViewById(R.id.ivImage);
        btnOrder = findViewById(R.id.btnOrder);

        food = getIntent().getParcelableExtra("food");

        if (food != null) {
            tvName.setText(food.getName());
            tvDescription.setText(food.getDescription());
            tvPrice.setText("Giá: " + food.getPrice() + " VND");
            ivImage.setImageResource(food.getImage());

            SharedPrefManager.saveLastViewedFood(this, food.getName());

            btnOrder.setOnClickListener(v -> {
                SharedPrefManager.saveLastOrderedFood(this, food.getName()); // Ghi vào SharedPreferences
                Intent resultIntent = new Intent();
                resultIntent.putExtra("orderedFood", food); // Trả lại đối tượng
                setResult(RESULT_OK, resultIntent);
                finish();
            });
        }
    }
}
