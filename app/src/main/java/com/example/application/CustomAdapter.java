package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Word> {

    private int background_color;
    public CustomAdapter(Context context, ArrayList<Word> words, int background_color) {
        super(context, 0, words);
        this.background_color = background_color;
    }
    public CustomAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ListItemView=convertView;
        if (ListItemView==null){
            ListItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word courrentword=getItem(position);
        ImageView imageView=ListItemView.findViewById(R.id.image);
        if (courrentword.gethashimage()){
         imageView.setVisibility(View.VISIBLE);
         imageView.setImageResource(courrentword.getImage());
        }else {
            imageView.setVisibility(View.GONE);
        }
        LinearLayout linearLayout=ListItemView.findViewById(R.id.Linear_background);
        linearLayout.setBackgroundResource(background_color);
        TextView nameText=ListItemView.findViewById(R.id.name);
        nameText.setText(courrentword.getName());
        TextView ageText=ListItemView.findViewById(R.id.age);
        ageText.setText(courrentword.getAge());
        return ListItemView;

    }
}
