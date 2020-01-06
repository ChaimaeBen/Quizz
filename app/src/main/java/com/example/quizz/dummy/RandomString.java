package com.example.quizz.dummy;

import androidx.annotation.NonNull;

import java.util.Random;

public class RandomString {

    public RandomString(){

    }
        private static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    public static String getSOURCES() {
        return SOURCES;
    }

    @NonNull
        public final String generateString(Random random, String characters, int length) {
            char[] text = new char[length];
            int i = 0;

            for(int var6 = length; i < var6; ++i) {
                text[i] = characters.charAt(random.nextInt(characters.length()));
            }

            return new String(text);
        }
}
