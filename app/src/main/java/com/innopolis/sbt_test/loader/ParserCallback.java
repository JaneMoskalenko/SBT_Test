package com.innopolis.sbt_test.loader;


import com.innopolis.sbt_test.model.Character;

import java.util.List;

public interface ParserCallback {

    void onGetNewsList(List<Character> result);
    void onGetNewsList(String result);
}
