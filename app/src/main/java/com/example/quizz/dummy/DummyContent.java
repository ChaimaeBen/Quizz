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
            addItem(new Category("3", "Television",
                    "difficulty: meduim"));

        addItem(new Category("4", "Science & Nature",
                "difficulty: hard"));
        addItem(new Category("5", "Board games",
                "difficulty: easy"));
        addItem(new Category("6", "Mythology",
                "difficulty: hard"));
        addItem(new Category("7", "Animals",
                "difficulty: meduim"));
        addItem(new Category("8", "Politics",
                "difficulty: meduim"));
        addItem(new Category("9", "Vehicles",
                "difficulty: easy"));
        addItem(new Category("10", "Geography",
                "difficulty: hard"));

        addItem(new Category("11", "Film",
                "difficulty: hard"));

        addItem(new Category("12", "Sports",
                "difficulty: easy"));
        }

    private static void addItem(Category item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }



}
