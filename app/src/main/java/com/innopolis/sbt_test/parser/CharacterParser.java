package com.innopolis.sbt_test.parser;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.Scanner;

public class CharacterParser {

    private static final String URL = "https://www.anapioficeandfire.com/api/characters";
    private static final String TAG = CharacterParser.class.getSimpleName();

    public static void parsing() throws Exception
    {
        URL url = new URL(URL);

// read from the URL
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

// build a JSON object
        JSONObject obj = new JSONObject(str);
        String json = obj.toString();

        JSONArray charArr = obj.getJSONArray("");

     /*   JSONObject character = obj.getJSONObject("");
        Log.d(TAG, "culture" + character.getString("culture"));*/

   /*     if (! obj.getString("status").equals("OK")) {
            Log.d(TAG, "STATUS " + "NOT OK");
            return;
        }
        else Log.d(TAG, "STATUS " + " OK");*/

/*
             JSONArray arr = obj.getJSONArray("titles");
        for (int i = 0; i < arr.length(); i++)
        System.out.println(arr.getInt(i));*/

    // get the first result

       /* JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        System.out.println(res.getString("formatted_address"));
        JSONObject loc =
                res.getJSONObject("geometry").getJSONObject("location");
        System.out.println("lat: " + loc.getDouble("lat") +
                ", lng: " + loc.getDouble("lng"));*/
    }
}
