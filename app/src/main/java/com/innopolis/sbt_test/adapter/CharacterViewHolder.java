package com.innopolis.sbt_test.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.innopolis.sbt_test.OnListItemCallback;
import com.innopolis.sbt_test.R;
import com.innopolis.sbt_test.model.Character;


class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnListItemCallback callback;
    TextView tv_name, tv_born, tv_died, tv_culture, tv_gender;
    ImageView img_isAlive;
    int position;
    Character names;

    public CharacterViewHolder(View itemView, OnListItemCallback callback) {
        super(itemView);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_born = (TextView) itemView.findViewById(R.id.tv_born);
        tv_died = (TextView) itemView.findViewById(R.id.tv_died);
        tv_culture = (TextView) itemView.findViewById(R.id.tv_culture);
        tv_gender = (TextView) itemView.findViewById(R.id.tv_gender);
        img_isAlive = (ImageView) itemView.findViewById(R.id.img_isAlive);
        this.callback = callback;
        itemView.setOnClickListener(this);
    }

    public void setData(Character names, int position) {
        this.tv_name.setText(names.getName());
        this.tv_born.setText(names.getBorn());
        this.tv_died.setText(names.getDied());
        this.tv_culture.setText(names.getCulture());
        this.tv_gender.setText(names.getGender());

        if (names.isAlive()){
            this.img_isAlive.setImageResource(R.drawable.sword);
        }
        else {
            this.img_isAlive.setImageResource(R.drawable.cemetery);
        }

        this.position = position;
        this.names = names;
    }

    @Override
    public void onClick(View view) {
        callback.onClick(names);

    }
}
