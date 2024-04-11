package com.example.catinfo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CatAPIService {
    private static final String API_BASE_URL = "https://api.thecatapi.com/v1/";

    public List<CatBreed> getBreeds() {
        try {
            URL url = new URL(API_BASE_URL + "breeds");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                InputStreamReader reader = new InputStreamReader(conn.getInputStream());
                Type listType = new TypeToken<List<CatBreed>>(){}.getType();
                return new Gson().fromJson(reader, listType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
