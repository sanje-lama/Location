package com.example.android.walkmyandroid;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FetchAddressTask extends AsyncTask<Location, Void, String> {

    private final String TAG = FetchAddressTask.class.getSimpleName();

     Context context;

    private Location location;


    public FetchAddressTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Location... locations) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());

        List<Address> addressList = null;
        String resultMessage = "";

        try {
            addressList = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(), 1);

        } catch (IOException e) {
            resultMessage = context.getString(R.string.service_not_available);
            Log.e(TAG, resultMessage, e);


    }

        return resultMessage;
}



    @Override
    protected void onPostExecute(String s){
            super.onPostExecute(s);

    }
}