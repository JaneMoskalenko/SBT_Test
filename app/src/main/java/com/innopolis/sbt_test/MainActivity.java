package com.innopolis.sbt_test;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.innopolis.sbt_test.loader.HttpGetRequest;
import com.innopolis.sbt_test.loader.ParserCallback;
import com.innopolis.sbt_test.model.Character;
import com.innopolis.sbt_test.parser.CharacterParser;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ParserCallback {
    private static final String TAG = MainActivity.class.getSimpleName();


    RecyclerView recview;
    TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_test = (TextView) findViewById(R.id.tv_test);
        recview = (RecyclerView) findViewById(R.id.recview);

        if(isConnected()){
            HttpGetRequest loader = new HttpGetRequest(this);
            loader.execute();
        }
        else{
            Toast.makeText(this,"Отсутствует подключение к Интернету", Toast.LENGTH_LONG).show();
            Log.d(TAG, "No internet connection");
        }
    }

    // check network connection
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    @Override
    public void onGetNewsList(List<Character> result) {

    }

    @Override
    public void onGetNewsList(String result) {
        tv_test.setText(result);
    }


}
