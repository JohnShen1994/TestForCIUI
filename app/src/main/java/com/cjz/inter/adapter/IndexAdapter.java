package com.cjz.inter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rjjs.intercept.testforciui.R;

/**
 * Created by Administrator on 2016/6/16.
 */

public class IndexAdapter extends BaseAdapter{
    private IndexItem[] indexItem = {new IndexItem("黑名单"), new IndexItem("骚扰电话"), new IndexItem("垃圾短信")};
    LayoutInflater inflater;
    int id_indexlist_item;

    public IndexAdapter(Context context, int id_indexlist_item){
        this.id_indexlist_item = id_indexlist_item;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return indexItem.length;
    }

    @Override
    public Object getItem(int position) {
        return indexItem[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout indexList = (LinearLayout)inflater.inflate(id_indexlist_item, parent, false);
        TextView tv = (TextView)indexList.findViewById(R.id.id_tv);
        tv.setText(indexItem[position].data);
        return indexList;
    }

    private class IndexItem{
        String data;
        public IndexItem(String data){
            this.data = data;
        }
    }
}
