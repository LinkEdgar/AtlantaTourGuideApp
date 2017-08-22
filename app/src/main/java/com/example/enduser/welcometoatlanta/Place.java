package com.example.enduser.welcometoatlanta;

import android.widget.ImageView;

/**
 * Created by EndUser on 8/4/2017.
 */

public class Place {
    private String locationCoordinates;
    private String nameofLocation;
    private String description;
    private String hours;
    private String imageUrl;

    public Place(){

    }
    public Place(String name, String description, String hours,String url, String location){
        nameofLocation = name;
        this.description = description;
        this.hours = hours;
        imageUrl = url;
        locationCoordinates = location;
    }


    public String getLocationName(){
        return nameofLocation;
    }
    public String getDescription(){
        return description;
    }
    public String getHours(){
        return hours;
    }
    public String getImageUrl(){return imageUrl;}
    public String getLocationCoordinates(){return locationCoordinates;}
    public boolean hasImage(){
        if(imageUrl.length() < 1 || imageUrl == null ){
            return false;
        }
        else{
            return true;
        }
    }

}
