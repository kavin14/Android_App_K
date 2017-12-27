package com.example.infostretch.kaiserpermanante.searchpage;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.infostretch.kaiserpermanante.MainActivity;
import com.example.infostretch.kaiserpermanante.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infostretch on 12/26/17.
 */

//my key AIzaSyDGfEcnaBjRD-6PP_eVqQHarU0gONieoNY
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=37.395751,-121.985481&radius=500&type=pharmacy&keyword=walgreens&key=AIzaSyDGfEcnaBjRD-6PP_eVqQHarU0gONieoNY
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=37.395751,-121.985481&radius=10000&keyword=pharmacy&key=AIzaSyDGfEcnaBjRD-6PP_eVqQHarU0gONieoNY


 /* public class FetchData  {
    private Context context;
    private List<DataSet> list = new ArrayList<DataSet>();
    private ListView listView;
    private Adapter adapter;



   public FetchData(Context context) {
       this.context = context;
    }

    public List<DataSet> searchPharmacy(){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        final String myUrl = "https://raw.githubusercontent.com/iCodersLab/Custom-ListView-Using-Volley/master/richman.json";
        final Gson json = new Gson();
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                myUrl,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject obj = response.getJSONObject(i);
                        DataSet dataSet = new DataSet();
                        dataSet.setName(obj.getString("name"));
                        dataSet.setImage(obj.getString("image"));
                        dataSet.setWorth(obj.getString("worth"));
                        dataSet.setYear(obj.getInt("InYear"));
                        dataSet.setSource(obj.getString("source"));
                        list.add(dataSet);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        AlertDialog.Builder add = new AlertDialog.Builder(context);
                        add.setMessage(response.toString()).setCancelable(true);
                        AlertDialog alert = add.create();
                        alert.setTitle("Error!!!");
                        alert.show();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder add = new AlertDialog.Builder(context);
                add.setMessage(error.getMessage()).setCancelable(true);
                AlertDialog alert = add.create();
                alert.setTitle("Error!!!");
                alert.show();
            }
        });
        requestQueue.add(jsonObjectRequest);
        return list;
        }
    }

*/