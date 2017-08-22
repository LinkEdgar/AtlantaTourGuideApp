package com.example.enduser.welcometoatlanta;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by EndUser on 8/5/2017.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Activity context, ArrayList<Place> place){
        super(context,0, place);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //gets the current list view
        View listItemView = convertView;
        //check if the listview is null
        if(listItemView == null) {
            //if it is then we inflate it
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.places_textview, parent, false);
        }
            //get a reference of the current Place object in the adapter
            Place currentPlace = getItem(position);
            //change the current view's title of place
            TextView locationName = (TextView) listItemView.findViewById(R.id.place_name);
            locationName.setText(currentPlace.getLocationName());

            TextView locationDescription = (TextView) listItemView.findViewById(R.id.place_description);
            locationDescription.setText(currentPlace.getDescription());

            TextView locationHours = (TextView) listItemView.findViewById(R.id.set_hour_textview);
            locationHours.setText(currentPlace.getHours());

        //Picasso set image through picasso

        ImageView locationImage = (ImageView) listItemView.findViewById(R.id.place_image);
        if(currentPlace.hasImage()) {
            Picasso.with(getContext()).load(currentPlace.getImageUrl()).into(locationImage);
        }

        return listItemView;
    }

}
