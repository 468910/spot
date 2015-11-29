package Domain.DomainObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 02/10/15.
 */
public class Playlist extends Entity {

    public Playlist(int id, String owner, String name){
        this.owner = owner;
        this.name = name;
    }

    public Playlist(){

    }



    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String owner;

    private String name;

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Availability availability;

    public ArrayList<Track> getTracks() {
        return tracks;
    }


    private ArrayList<Track> tracks = new ArrayList<Track>();

    public void add(Track track){
        tracks.add(track);
    }

    public void changeName(String name){
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

}
