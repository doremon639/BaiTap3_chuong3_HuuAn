package com.example.food3;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String PREF_NAME = "food_pref";
    private static final String KEY_LAST_VIEWED = "last_viewed_food";
    private static final String KEY_LAST_ORDERED = "last_ordered_food";

    public static void saveLastViewedFood(Context context, String foodName) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_LAST_VIEWED, foodName).apply();
    }

    public static String getLastViewedFood(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString(KEY_LAST_VIEWED, null);
    }

    public static void saveLastOrderedFood(Context context, String foodName) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_LAST_ORDERED, foodName).apply();
    }

    public static String getLastOrderedFood(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString(KEY_LAST_ORDERED, null);
    }
}
