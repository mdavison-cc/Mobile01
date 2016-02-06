package com.example.administrator.prog3150_assignment1;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    View v;
    SharedPreferences data;
    int key;

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_view, container, false);

        MainActivity activity = (MainActivity) getActivity();
        data = activity.GetData();
        key = activity.GetKey();


        for (int i = key; i > 0; i--)
        {

            Gson gson = new Gson();
            String json = data.getString(Integer.toString(i), "");
            Debtor cur = gson.fromJson(json, Debtor.class);

            LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.view);


            TextView t1 = new TextView(getContext());
            t1.setText(cur.Firstname);
            t1.setPadding(5, 20, 0, 0);
            linearLayout.addView(t1);

            TextView t2 = new TextView(getContext());
            t2.setText(cur.Lastname);
            t2.setPadding(5, 20, 0, 0);
            linearLayout.addView(t2);

            TextView t3 = new TextView(getContext());
            t3.setText(cur.Number);
            t3.setPadding(5, 20, 0, 0);
            linearLayout.addView(t3);

            TextView t4 = new TextView(getContext());
            t4.setText(cur.Email);
            t4.setPadding(5, 20, 0, 0);
            linearLayout.addView(t4);

            TextView t5 = new TextView(getContext());
            t5.setText(cur.Date);
            t5.setPadding(5, 20, 0, 0);
            linearLayout.addView(t5);

            TextView t6 = new TextView(getContext());
            t6.setText(cur.Amount);
            t6.setPadding(5, 20, 0, 0);
            linearLayout.addView(t6);

        }
        return v;
    }

}
