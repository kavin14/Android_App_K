package com.example.infostretch.kaiserpermanante.searchpage;

/**
 * Created by infostretch on 12/26/17.
 */

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.infostretch.kaiserpermanante.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by Hatesh kumar on 11/07/2016.
 */

public class Adapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<DataSet> addressList = null;
    private ArrayList<DataSet> addressArrayList;


    public Adapter(Context context, List<DataSet> addressList) {
        mContext = context;
        this.addressList = addressList;
        inflater = LayoutInflater.from(mContext);
        this.addressArrayList = new ArrayList<DataSet>();
        this.addressArrayList.addAll(addressList);
    }

    static class ViewHolder{
        TextView address;
    }

    @Override
    public int getCount() {
       return addressList.size();
    }

    @Override
    public DataSet getItem(int position) {
        return addressList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            final ViewHolder holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.r_list_view,null);
            holder.address = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.address.setText(addressList.get(position).getName());
        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        addressList.clear();
        if (charText.length() == 0) {
            addressList.addAll(addressArrayList);
        } else {
            for (DataSet wp : addressArrayList) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    addressList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}