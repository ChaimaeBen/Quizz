package com.example.quizz.dummy;

import com.example.quizz.models.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DummyContent {


    public static final List<Category> ITEMS = new ArrayList<Category>();

    public static final Map<String, Category> ITEM_MAP = new HashMap<String, Category>();

    static {

            // Add 3 sample items.
            addItem(new Category("1", "History",
                    "difficulty: hard"));
            addItem(new Category("2", "Video Games",
                    "difficulty: easy"));
            addItem(new Category("3", "Geography",
                    "difficulty: meduim"));
        }

    private static void addItem(Category item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Category createDummyItem(int position) {
        return new Category(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


}
