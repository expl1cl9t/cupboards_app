package com.example.cupboards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CupboardAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    List<Cupboard> source;
    CupboardAdapter(Context context, List<Cupboard>source){
        this.context = context;
        this.source = source;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return source.size();
    }

    @Override
    public Object getItem(int i) {
        return source.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View contView = view;
        if(view == null){
            inflater.inflate(R.layout.item,null,true);
        }
        Cupboard cup = getCupboard(i);
        ((TextView)view.findViewById(R.id.Name)).setText(cup.Name);
        ((TextView)view.findViewById(R.id.ID)).setText(cup.id);
        return view;
    }
    Cupboard getCupboard(int pos){
        return (Cupboard) getItem(pos);
    }
}
