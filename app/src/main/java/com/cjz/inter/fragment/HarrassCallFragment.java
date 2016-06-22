package com.cjz.inter.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjjs.intercept.testforciui.R;

/**
 * Created by Administrator on 2016/6/17.
 *
 */
public class HarrassCallFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_harasscall, container, false);
        TextView tvBlackname = (TextView)rootView.findViewById(R.id.tv_title);
        tvBlackname.setText("骚扰电话");
        return rootView;
    }
}
