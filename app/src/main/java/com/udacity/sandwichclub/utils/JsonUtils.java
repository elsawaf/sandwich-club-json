package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private final static String NAME_JSON_KEY = "name";
    private final static String MAINNAME_JSON_KEY = "mainName";
    private final static String ALSOKNOWNAS_JSON_KEY = "alsoKnownAs";
    private final static String PLACEOFORIGIN_JSON_KEY = "placeOfOrigin";
    private final static String DESCRIPTION_JSON_KEY = "description";
    private final static String IMAGE_JSON_KEY = "image";
    private final static String INGREDIENTS_JSON_KEY = "ingredients";

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich sandwich = null;
        if (json != null && !json.isEmpty()) {
            JSONObject sandwichJSON = new JSONObject(json);

            JSONObject nameJSON = sandwichJSON.getJSONObject(NAME_JSON_KEY);
            String mainName = nameJSON.getString(MAINNAME_JSON_KEY);
            List<String> alsoKnownAs = new ArrayList<>();
            JSONArray alsoKnownAsJSON = nameJSON.getJSONArray(ALSOKNOWNAS_JSON_KEY);
            for (int i=0; i<alsoKnownAsJSON.length(); i++){
                String alsoKnownAsName = alsoKnownAsJSON.getString(i);
                alsoKnownAs.add(alsoKnownAsName);
            }

            String placeOfOrigin = sandwichJSON.getString(PLACEOFORIGIN_JSON_KEY);

            String description = sandwichJSON.getString(DESCRIPTION_JSON_KEY);

            String image = sandwichJSON.getString(IMAGE_JSON_KEY);

            List<String> ingredients = new ArrayList<>();
            JSONArray ingredientsJSON = sandwichJSON.getJSONArray(INGREDIENTS_JSON_KEY);
            for (int i=0; i<ingredientsJSON.length(); i++){
                String ingredient = ingredientsJSON.getString(i);
                ingredients.add(ingredient);
            }

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }
        return sandwich;
    }
}
