package com.cjz.inter.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/21.
 */
public class CISimpleCursorAdapter extends SimpleCursorAdapter{
    private int bnlayout;
    private Cursor c;
    private String[] from;
    private int[] to;

    private LayoutInflater inflater;
    public CISimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        this.bnlayout = layout;
        this.c = c;
        this.from = from;
        this.to = to;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View geView(int position, View convertView, ViewGroup parent){
        if (c.moveToNext()){
            View v;
            v = inflater.inflate(bnlayout, parent, false);

            TextView blacknum = (TextView)v.findViewById(to[0]);
            String d = c.getString(c.getColumnIndex(from[0]));
            blacknum.setText(d);

            TextView id = (TextView)v.findViewById(to[1]);
            d = c.getString(c.getColumnIndex(from[1]));
            id.setText(d);

            if (c.isLast())c.moveToPosition(-1);
            return v;
        }
        return null;
    }
}
