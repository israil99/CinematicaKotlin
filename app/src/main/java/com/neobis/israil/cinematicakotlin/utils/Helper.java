package com.neobis.israil.cinematicakotlin.utils;

public class Helper {
    public static final String BASE_URL = "https://kinoafisha.ua/";


    public static String makeImageBetter(String url) {
        StringBuilder stringBuilder = new StringBuilder(url);
        for (int i = stringBuilder.length() - 1; i > 0; i--) {
            if (stringBuilder.charAt(i) == '/') {
                stringBuilder.deleteCharAt(i + 1);
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }

    public static String makeImageBest(String url) {
            url = url.replace("sm_","");
            return url;
        }
    }


