package com.example.food3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Food> foodList;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        foodList = new ArrayList<>();

        foodList.add(new Food("Phở", R.drawable.pho, "Phở bò truyền thống với nước dùng đậm đà.", 45000));
        foodList.add(new Food("Bún chả", R.drawable.buncha, "Bún chả Hà Nội thơm ngon, thịt nướng vàng ươm.", 40000));
        foodList.add(new Food("Bánh mì", R.drawable.banhmi, "Bánh mì kẹp thịt, rau sống, nước sốt.", 20000));
        foodList.add(new Food("Cơm tấm", R.drawable.comtam, "Cơm tấm sườn bì chả, trứng ốp la.", 50000));
        foodList.add(new Food("Gỏi cuốn", R.drawable.goicuon, "Gỏi cuốn tôm thịt, nước chấm đậm đà.", 30000));

        adapter = new FoodAdapter(this, foodList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        String lastViewed = SharedPrefManager.getLastViewedFood(this);
        String lastOrdered = SharedPrefManager.getLastOrderedFood(this);

        if (lastViewed != null) {
            Toast.makeText(this, "Bạn vừa xem: " + lastViewed, Toast.LENGTH_SHORT).show();
        }

        if (lastOrdered != null) {
            Toast.makeText(this, "Bạn đã gọi món: " + lastOrdered, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Food orderedFood = data.getParcelableExtra("orderedFood");
            Toast.makeText(this, "Bạn đã gọi món: " + orderedFood.getName(), Toast.LENGTH_LONG).show();
        }
    }
}
