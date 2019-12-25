package com.example.quizz.dummy;

import com.example.quizz.models.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Category> ITEMS = new ArrayList<Category>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Category> ITEM_MAP = new HashMap<String, Category>();


    static {
        // Add some sample items.
                    addItem(new Category(1, "History",   "difficulty: hard"));
                    addItem(new Category(2, "Video Games", "difficulty: easy"));
                    addItem(new Category(3, "Television", "difficulty: meduim"));

                    addItem(new Category(4, "Science & Nature",  "difficulty: hard"));
                    addItem(new Category(5, "Board games",  "difficulty: easy"));
                    addItem(new Category(6, "Mythology","difficulty: hard"));
                    addItem(new Category(7, "Animals","difficulty: meduim"));
                    addItem(new Category(8, "Politics",  "difficulty: meduim"));
                    addItem(new Category(9, "Vehicles", "difficulty: easy"));
                    addItem(new Category(10, "Geography",  "difficulty: hard"));

                    addItem(new Category(11, "Film","difficulty: hard"));

                    addItem(new Category(12, "Sports", "difficulty: easy"));
    }

    private static void addItem(Category item) {
        ITEMS.add(item);


     ITEM_MAP.put(String.valueOf(item.category_id), item);
        System.out.println(ITEM_MAP);

    }

    private static Category createDummyItem(int position) {
        return new Category(position, "Item " + position, makeDetails(position));
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
