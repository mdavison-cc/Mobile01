/*
MainActivity.java
Assignment: Mobile Application Developement
Brandon Davison, Brandon Erb and Nick Nathaniels
Date: Feb 2, 2016
Description: Mobile Application Development Assignment 1
*/
package com.example.administrator.prog3150_assignment1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AddFragment.AddFragmentInterface {

    NavigationView navigationView;
    Toolbar toolbar;
    SharedPreferences data;

    Button dateDialogButton;
    int dateDialogId = 0;
    int theYear, theMonth, theDay;
    int key = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        data = this.getPreferences(Context.MODE_PRIVATE);
        ViewFragment fragment = new ViewFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(getIntent().getExtras());
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_view) {


            ViewFragment fragment = new ViewFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragment.setArguments(getIntent().getExtras());
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_add) {

            AddFragment fragment = new AddFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();




        } else if (id == R.id.nav_pay) {

            PayFragment fragment = new PayFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragment.setArguments(getIntent().getExtras());
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void OnAddDebtor(String firstName, String lastName, String number, String email, String amount, int year, int month, int day) {
        Toast.makeText(MainActivity.this, firstName + " " + lastName + " " + number + " " + email + " " +  amount, Toast.LENGTH_SHORT).show();
        key++;

        SharedPreferences.Editor edit = data.edit();

        String Date = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
        Debtor debtor = new Debtor(firstName, lastName, number, email, Date, amount);
        Gson gson = new Gson();
        edit.putString(Integer.toString(key), gson.toJson(debtor));
        edit.commit();




    }


    public SharedPreferences GetData()
    {
        return data;
    }


    public int GetKey()
    {
        return key;
    }
}
