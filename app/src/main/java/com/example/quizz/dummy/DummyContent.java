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
            addItem(new Category(0, "History",
                    "difficulty: hard"));
            addItem(new Category(0, "Video Games",
                    "difficulty: easy"));
            addItem(new Category(0, "Television",
                    "difficulty: meduim"));

        addItem(new Category(0, "Science & Nature",
                "difficulty: hard"));
        addItem(new Category(0, "Board games",
                "difficulty: easy"));
        addItem(new Category(0, "Mythology",
                "difficulty: hard"));
        addItem(new Category(0, "Animals",
                "difficulty: meduim"));
        addItem(new Category(0, "Politics",
                "difficulty: meduim"));
        addItem(new Category(0, "Vehicles",
                "difficulty: easy"));
        addItem(new Category(0, "Geography",
                "difficulty: hard"));

        addItem(new Category(0, "Film",
                "difficulty: hard"));

        addItem(new Category(0, "Sports",
                "difficulty: easy"));
        }

    private static void addItem(Category item) {
        ITEMS.add(item);
        ITEM_MAP.put(String.valueOf(item.category_id), item);
    }



}
