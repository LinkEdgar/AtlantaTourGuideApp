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


/**
 * A simple {@link Fragment} subclass.
 */
public class MustVisitFragment extends Fragment {


    public MustVisitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root_view = inflater.inflate(R.layout.place_list_view,container,false);

        final ArrayList<Place> mustVisitPlace = new ArrayList<>();
        mustVisitPlace.add(new Place("World of Coca-Cola","World of Coca-Cola shows the history of the brand and its Atlanta origins. Take a our a get ready to varies flaovrs as at the end of the tour you are welcomed to taste several sodas from around the world.", "9AM-6PM","http://familyfoodandtravel.com/wp-content/uploads/2014/03/The-World-of-Coca-Cola.jpg.jpg","https://www.google.com/maps/search/?api=1&query=world+of+coca+cola"));
        mustVisitPlace.add(new Place("Georgia Aquarium","Visit the largest aquarium in the Western Hemisphere. Come see what the Georgia aquarium has to offer, such as the dolphin show which may or may not include the abuse of the beuatiful creatures you see there.", "10AM-7PM","https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Georgia_Aquarium_Jan_2006.jpg/1200px-Georgia_Aquarium_Jan_2006.jpg","https://www.google.com/maps/search/?api=1&query=georgia+aquarium"));
        mustVisitPlace.add(new Place("Centennial Olympic Park","A beautiful park built as for the Atlanta Summer Olympics of 1996. There are several tributes to the athletes that participated in the olympics.", "10AM-7PM","https://www.omnihotels.com/-/media/images/hotels/atlcnn/activities/atlcnn-centennial-park.jpg?h=660&la=en&w=1170","https://www.google.com/maps/search/?api=1&query=centennial+park"));

        //mustVisitPlace.add("Georgia Aquarium");
        //mustVisitPlace.add("Centennial Olympic Park");
        //Array adpapter used to efficiently store information
        PlaceAdapter mustVisitAdapter = new PlaceAdapter(getActivity(), mustVisitPlace);
        //reference to a list view to set up our adapter
        ListView listView = (ListView) root_view.findViewById(R.id.list_view);
        // set the adapter to organize the data and bam
        listView.setAdapter(mustVisitAdapter);

        //Listview listener for directions
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place place = mustVisitPlace.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geolocation = Uri.parse(place.getLocationCoordinates());
                intent.setData(geolocation);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }

            }
        });



        return root_view;
    }

}
