/*
PayFragment.java
Assignment: Mobile Application Developement
Brandon Davison, Brandon Erb and Nick Nathaniels
Date: Feb 2, 2016
Description: Mobile Application Development Assignment 1
*/
package com.example.administrator.prog3150_assignment1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends Fragment {


    public PayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay, container, false);
    }

}
