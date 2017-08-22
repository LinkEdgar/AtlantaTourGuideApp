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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThingsToDoFragment extends Fragment {


    public ThingsToDoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list_view,container,false);
        final ArrayList<Place> thingsToDO = new ArrayList<>();
        thingsToDO.add(new Place("Fourth Ward Park","So much to do as this park expands through Atlanta and even includes a skate-park", "8AM-12AM", "http://beltlandia.com/wp-content/uploads/2012/07/Historic-Fourth-Ward-Park-at-night.jpg", "https://www.google.com/maps/search/?api=1&query=fourth+ward+park"));
        thingsToDO.add(new Place("Atlanta Ferris Wheel","With a location close to Centennial Olypic park you can visit both places for an unforgetable expereince","10AM-12Am", "http://res.cloudinary.com/simpleview/image/upload/w_485,h_300,c_fill/crm/atlanta/J0041036_420c99aa-5056-b3a8-49ff14d8df8d68c0.jpg","https://www.google.com/maps/search/?api=1&query=SkyView"));
        PlaceAdapter thingsToDoAdapter = new PlaceAdapter(getActivity(),thingsToDO);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(thingsToDoAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place place = thingsToDO.get(position);
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
