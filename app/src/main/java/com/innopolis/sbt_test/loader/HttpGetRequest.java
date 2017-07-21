package com.innopolis.sbt_test.loader;


import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.innopolis.sbt_test.model.Character;
import com.innopolis.sbt_test.parser.CharacterParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpGetRequest extends AsyncTask<String, Void, String> {

    public static final String REQUEST_METHOD = "GET";
    private static final String URL = "https://www.anapioficeandfire.com/api/characters";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    private static final String TAG = HttpGetRequest.class.getSimpleName();

    private ParserCallback mParserCallback;
    private List<Character> mCharacterList = new ArrayList<Character>();

    public HttpGetRequest(ParserCallback parserCallback) {
        mParserCallback = parserCallback;
    }

    @Override
    protected String doInBackground(String... params){
        String result = null;
        String inputLine;

        CharacterParser parser = new CharacterParser();
        try {
            parser.parsing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        //return getGETRequest();
    }

    @Nullable
    private String getGETRequest() {
        String inputLine;
        String result;
        try {
            //Create a URL object holding our url
            URL myUrl = new URL(URL);
            //Create a connection
            HttpURLConnection connection =(HttpURLConnection)
                    myUrl.openConnection();
            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Connect to our url
            connection.connect();

            //Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            //Check if the line we are reading is not null
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }

            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();
            //Set our result equal to our stringBuilder
            result = stringBuilder.toString();
            Log.d(TAG, "RESULT " + result);
        }
        catch(IOException e){
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
         mParserCallback.onGetNewsList(response);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
