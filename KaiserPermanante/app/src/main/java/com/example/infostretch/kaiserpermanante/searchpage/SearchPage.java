package com.example.infostretch.kaiserpermanante.searchpage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.infostretch.kaiserpermanante.MainActivity;
import com.example.infostretch.kaiserpermanante.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

//my key AIzaSyDGfEcnaBjRD-6PP_eVqQHarU0gONieoNY
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=37.395751,-121.985481&radius=500&type=pharmacy&keyword=walgreens&key=AIzaSyDGfEcnaBjRD-6PP_eVqQHarU0gONieoNY
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=37.395751,-121.985481&radius=10000&keyword=pharmacy&key=AIzaSyDGfEcnaBjRD-6PP_eVqQHarU0gONieoNY
public class SearchPage extends AppCompatActivity {

    private static final String tag = MainActivity.class.getSimpleName();
    private static final String url = "https://raw.githubusercontent.com/iCodersLab/Custom-ListView-Using-Volley/master/richman.json";


    ListView list;
    Adapter adapter;
    SearchView editsearch;
    String[] addressList;
    ArrayList<DataSet> arraylist = new ArrayList<DataSet>();
    int Rand ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        addressList = new String[]{"Walgreens", "CVS", "Kaiser permanante"};

        list = (ListView) findViewById(R.id.listView);

        for (int i = 0; i < 20; i++) {
            Rand = new Random().nextInt(3) + 1;
            DataSet dS = new DataSet(addressList[Rand-1] + " " + i);
            // Binds all strings into an array
            arraylist.add(dS);
        }

        adapter = new Adapter(this,arraylist);

        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.SearchText);
        editsearch.requestFocus();
        editsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adapter.filter(text);
                return false;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),adapter.getItem(position).getName(),Toast.LENGTH_SHORT).show();

                Intent i = new Intent(SearchPage.this,MainActivity.class);
                i.putExtra("selected_pharmacy",adapter.getItem(position).getName() );
                startActivity(i);
            }
        });
    }
}



