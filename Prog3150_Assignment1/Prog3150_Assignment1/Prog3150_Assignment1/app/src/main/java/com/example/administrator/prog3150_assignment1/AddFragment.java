/*
AddFragment.java
Assignment: Mobile Application Developement
Brandon Davison, Brandon Erb and Nick Nathaniels
Date: Feb 2, 2016
Description: Mobile Application Development Assignment 1
*/
package com.example.administrator.prog3150_assignment1;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment  {

    Button dateDialogButton, addDebtorButton;
    String firstName, lastName, email, number, amount;
    EditText EditLastName, EditEmail, EditNumber, EditFirstName, EditAmount;
    int dateDialogId = 0;
    int theYear, theMonth, theDay;
    View v;
    Activity activity;

    public AddFragment() {
        // Required empty public constructor

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_add, container, false);
        final Dialog dialog = new DatePickerDialog(getActivity(), datePickerListener, theYear, theMonth, theDay);

        dateDialogButton = (Button)v.findViewById(R.id.AddDateButton);
        dateDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        EditFirstName = (EditText)v.findViewById(R.id.AddFirstNameView);
        EditLastName = (EditText)v.findViewById(R.id.AddLastNameView);
        EditNumber = (EditText)v.findViewById(R.id.AddPhoneNumberView);
        EditEmail = (EditText)v.findViewById(R.id.AddEmailView);
        EditAmount = (EditText)v.findViewById(R.id.AddPaymentAmountView);

        addDebtorButton = (Button)v.findViewById(R.id.AddDebtorButton);
        addDebtorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                firstName = EditFirstName.getText().toString();
                lastName = EditLastName.getText().toString();
                number = EditNumber.getText().toString();
                email = EditEmail.getText().toString();
                amount = EditAmount.getText().toString();

                if((firstName != " ")&&(lastName != " ")&&(number != " ")&&(email != " ")&&(amount != " "))
                {
                    try{
                        ((AddFragmentInterface) activity).OnAddDebtor(firstName, lastName, number, email, amount, theYear, theMonth, theDay);
                    }catch (ClassCastException cce){

                    }

                }
            }
        });
        return v;
    }

    DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            theYear = year;
            theMonth = monthOfYear;
            theDay = dayOfMonth;
        }
    };


    public interface AddFragmentInterface{

        public void OnAddDebtor(String firstName, String lastName, String number, String email, String amount, int year, int month, int day);
    }

}
