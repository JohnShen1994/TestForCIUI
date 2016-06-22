package com.cjz.inter.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cjz.inter.adapter.CISimpleCursorAdapter;
import com.cjz.inter.db.CIDataBaseHelper;
import com.rjjs.intercept.testforciui.R;

/**
 * Created by Administrator on 2016/6/17.
 *
 */
public class BlackNameFragment extends Fragment implements OnClickListener{
    private Button btn_insertBlackname;
    private LinearLayout insertbn = null;
    private String blacknum;
    private String blackname;
    private ListView lv;
    private View rootView;
    private static int select = 0;
    private CIDataBaseHelper helper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_blackname, container, false);
        TextView tvBlackname = (TextView)rootView.findViewById(R.id.tv_title);
        tvBlackname.setText("黑名单");

        btn_insertBlackname = (Button)rootView.findViewById(R.id.insert_blackname);
        btn_insertBlackname.setOnClickListener(this);

        lv = (ListView)rootView.findViewById(R.id.id_lv_blackname);
        helper = new CIDataBaseHelper(getActivity());
        SQLiteDatabase dbr = helper.getReadableDatabase();
        String[] columns = {"black_num","_id"};
        Cursor cur = dbr.query("black", columns, null,null,null,null,null);
        int[] li = {R.id.tv_fragment_list_item};
        CISimpleCursorAdapter ciad = new CISimpleCursorAdapter(getActivity(), R.layout.fragment_list_item, cur, columns, li);
        lv.setAdapter(ciad);
        return rootView;
    }

    @Override
    public void onClick(final View v) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        insertbn = (LinearLayout)inflater.inflate(R.layout.dialog_insertbn, null);

        AlertDialog ad = new AlertDialog.Builder(getActivity())
                .setView(insertbn)
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                blacknum = ((EditText) insertbn.findViewById(R.id.id_blnumber)).getText().toString();
                                blackname = ((EditText) insertbn.findViewById(R.id.id_blname)).getText().toString();
                                //CIDataBaseHelper helper = new CIDataBaseHelper(getActivity());
                                SQLiteDatabase dbw = helper.getWritableDatabase();

                                ContentValues values = new ContentValues();
                                values.put("black_num", blacknum);
                                values.put("black_name", blackname);
                                dbw.insert("black", null, values);

                                dbw.close();
                                BlackNameFragment.chanceButton(BlackNameFragment.select);
                                SQLiteDatabase dbr = helper.getReadableDatabase();
                                String[] columns = {"black_num","_id"};
                                Cursor cur = dbr.query("black", columns, null,null,null,null,null);
                                int[] li = {R.id.tv_fragment_list_item};
                                CISimpleCursorAdapter ciad = new CISimpleCursorAdapter(getActivity(), R.layout.fragment_list_item, cur, columns, li);
                                lv.setAdapter(ciad);
                                Toast.makeText(getActivity(), blacknum, Toast.LENGTH_LONG).show();
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.cancel();
                            }
                        }).create();
        ad.show();
    }
    private static  void chanceButton(int i){
        if(i==0){

        }
    }
}
