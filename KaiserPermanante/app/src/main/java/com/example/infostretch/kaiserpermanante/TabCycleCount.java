package com.example.infostretch.kaiserpermanante;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.example.infostretch.kaiserpermanante.dialogs.errorDialog;
import com.example.infostretch.kaiserpermanante.homepage.HomePage;
import com.example.infostretch.kaiserpermanante.searchpage.SearchPage;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.Validator.ValidationListener;

import java.util.List;

public class TabCycleCount extends Fragment {
    Button login;
    EditText userName;
    EditText password;
    EditText searchText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_tab_cycle_count,container,false);


        login = (Button) v.findViewById(R.id.button);
        userName = (EditText) v.findViewById(R.id.userName);
        password = (EditText) v.findViewById(R.id.password);
        searchText = (EditText) v.findViewById(R.id.selectPharmacy);

        if(getActivity().getIntent().getExtras() != null){
            searchText.setText(getActivity().getIntent().getExtras().getString("selected_pharmacy"));
        }

        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Hello",Toast.LENGTH_SHORT).show();
                if(userName.getText().length() == 0 || password.getText().length() == 0){
                    popUpShow("User name cannot be empty");
                }else{
                    Intent i = new Intent(getActivity(), HomePage.class);
                    startActivity(i);
                }


            }
        });

        searchText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Intent i = new Intent(getActivity(), SearchPage.class);
                startActivity(i);
            }
        });
      /*  searchText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SearchPage.class);
                startActivity(i);
            }
        });*/


        return v;
    }
    public void popUpShow(String message){
        AlertDialog.Builder mBuilder =  new AlertDialog.Builder(getActivity());
        mBuilder
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("Ok",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = mBuilder.create();

        alertDialog.show();
        alertDialog.getButton(Dialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
    }

}
