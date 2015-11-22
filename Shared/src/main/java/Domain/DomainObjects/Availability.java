package Domain.DomainObjects;

/**
 * Created by apple on 02/10/15.
 */
public class Availability extends Entity {
    private boolean offlineAvailable;

    private int playlist_Id;
    private int track_Id;


    public void toggle(){
        offlineAvailable = !offlineAvailable;
    }

    public boolean isOfflineAvailable(){
        return  offlineAvailable;
    }

    public int getPlaylist_Id() {
        return playlist_Id;
    }

    public void setPlaylist_Id(int playlist_Id) {
        this.playlist_Id = playlist_Id;
    }

    public int getTrack_Id() {
        return track_Id;
    }

    public void setTrack_Id(int track_Id) {
        this.track_Id = track_Id;
    }




}
