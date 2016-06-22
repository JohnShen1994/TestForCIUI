package com.cjz.inter.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cjz.inter.fragment.BlackNameFragment;
import com.cjz.inter.fragment.HarrassCallFragment;
import com.cjz.inter.fragment.SpamMsgFragment;

/**
 * Created by Administrator on 2016/6/17.
 *
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = this.getIntent();
        int id = intent.getIntExtra("id", -1);

        FragmentManager fm = this.getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN | FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        switch (id){
            case 0:
                BlackNameFragment bnf = new BlackNameFragment();
                transaction.add(android.R.id.content, bnf);
                break;
            case 1:
                HarrassCallFragment hcf = new HarrassCallFragment();
                transaction.add(android.R.id.content, hcf);
                break;
            case 2:
                SpamMsgFragment smf = new SpamMsgFragment();
                transaction.add(android.R.id.content, smf);
                break;
        }
        transaction.commit();
    }
}
