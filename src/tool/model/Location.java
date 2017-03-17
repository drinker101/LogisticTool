package tool.model;

/**
 * Created by Madman on 03.03.17.
 */
public class Location {

    private String geoPlace;

    private String locationName;


    public Location(){
        this.geoPlace="";
        this.locationName="";
    }

    public String getGeoPlace(){
        return this.geoPlace;
    }

    public void setGeoPlace(String geoPlace){
        this.geoPlace=geoPlace;

    }


    public String getLocationName(){
        return this.locationName;
    }

    public void setLocationName(String locationName){
        this.locationName=locationName;
    }

}
