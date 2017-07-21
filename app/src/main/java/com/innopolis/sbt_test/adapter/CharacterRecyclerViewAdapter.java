package com.innopolis.sbt_test.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.innopolis.sbt_test.OnListItemCallback;
import com.innopolis.sbt_test.R;
import com.innopolis.sbt_test.model.Character;

import java.util.List;


public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private List<Character> mData;
    private LayoutInflater mInflater;
    private OnListItemCallback callback;

    public CharacterRecyclerViewAdapter(Context context, List<Character> data, OnListItemCallback callback) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
        this.callback = callback;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.character_list, parent, false);
        CharacterViewHolder holder= new CharacterViewHolder(view, callback);
        return holder;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        Character names = mData.get(position);
        holder.setData(names, position);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
