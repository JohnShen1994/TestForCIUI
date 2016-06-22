package com.cjz.inter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.cjz.inter.adapter.IndexAdapter;
import com.rjjs.intercept.testforciui.R;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private ListView lv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)this.findViewById(R.id.id_lv);
        lv.setAdapter((new IndexAdapter(this, R.layout.list_item)));
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra("id", 0);
                this.startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(this, DetailActivity.class);
                intent1.putExtra("id", 1);
                this.startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this, DetailActivity.class);
                intent2.putExtra("id", 2);
                this.startActivity(intent2);
                break;
        }

    }
}

