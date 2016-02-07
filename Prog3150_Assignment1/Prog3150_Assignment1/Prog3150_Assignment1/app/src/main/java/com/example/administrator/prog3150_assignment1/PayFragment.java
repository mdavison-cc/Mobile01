package com.example.administrator.prog3150_assignment1;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;


/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends Fragment {


    View v;
    SharedPreferences data;
    int key;
    SearchView search;
    public PayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_pay, container, false);

        MainActivity activity = (MainActivity) getActivity();
        data = activity.GetData();
        key = activity.GetKey();
        search = (SearchView)v.findViewById(R.id.searchView);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                for (int i = key; i > 0; i--)
                {

                    Gson gson = new Gson();
                    String json = data.getString(Integer.toString(i), "");
                    Debtor cur = gson.fromJson(json, Debtor.class);

                    LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.nav_pay);
                    String name = cur.Firstname;
                    if(name == query)
                    {
                        TextView t1 = new TextView(getContext());
                        t1.setText(cur.Firstname);
                        t1.setPadding(5, 20, 0, 0);
                        linearLayout.addView(t1);

                        TextView t2 = new TextView(getContext());
                        t2.setText(cur.Lastname);
                        t2.setPadding(5, 20, 0, 0);
                        linearLayout.addView(t2);

                        TextView t3 = new TextView(getContext());
                        t3.setText("Amount Owed:");
                        t3.setPadding(5, 20, 0, 0);
                        linearLayout.addView(t3);

                        TextView t4 = new TextView(getContext());
                        t4.setText(cur.Amount);
                        t4.setPadding(5, 20, 0, 0);
                        linearLayout.addView(t4);


                    }




                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return v;
    }

}
