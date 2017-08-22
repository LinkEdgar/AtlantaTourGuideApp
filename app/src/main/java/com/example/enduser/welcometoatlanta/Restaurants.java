package com.example.enduser.welcometoatlanta;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.enduser.welcometoatlanta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Restaurants extends Fragment {


    public Restaurants() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //make the root a variable to use it to find IDs etc
        View rootView = inflater.inflate(R.layout.place_list_view,container,false);
        //store the restaurant information in an arraylist
        final ArrayList<Place> restaurants = new ArrayList<>();
        restaurants.add(new Place(" The Vortex", "Vortex is one of the coolest places in town just makes sure you're 21 and up","11AM-3AM","http://littlefivepoints.net/wp-content/uploads/2010/06/vortex_620x300.jpg","https://www.google.com/maps/search/?api=1&query=the+vortex" ));
        restaurants.add(new Place("Antico", "This is closest you will get to going to Italy! Treat your taste buds! ", "11AM-10PM","http://spatialdrift.com/wp-content/uploads/2014/02/2014-02-14-13.16.17-689x516.jpg","https://www.google.com/maps/search/?api=1&query=antico+pizza"));
        restaurants.add(new Place("Sweet Hut","If you're looking to get a delicious beverage and desert this is the place for you! ", "8AM-12AM", "http://spatialdrift.com/wp-content/uploads/2013/07/2013-06-29-14.13.01-1024x664.jpg","https://www.google.com/maps/search/?api=1&query=sweet+hut"));
        //restaurants.add("The Pagoda");


        //make an adapter for the list view to keep it efficient
        PlaceAdapter restaurantAdapter = new PlaceAdapter(getActivity(),restaurants);

        //find the list view to then display out restaurants
        ListView restaurantList = (ListView) rootView.findViewById(R.id.list_view);
        restaurantList.setAdapter(restaurantAdapter);


        //Listview listener for directions
        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place place = restaurants.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geolocation = Uri.parse(place.getLocationCoordinates());
                intent.setData(geolocation);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }

            }
        });


        return rootView;
    }

}
