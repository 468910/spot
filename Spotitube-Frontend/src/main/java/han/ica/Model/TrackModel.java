package han.ica.Model;

import Domain.DomainObjects.Track;
import Domain.Service.PlaylistService;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/10/15.
 */
public class TrackModel {
    public List<Track> tracks = new ArrayList<Track>();
    private final PlaylistService playlistService;

    @Inject
    public TrackModel(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    public List<Track> getTracks(String searchTerm){
       return playlistService.getAllTracks(searchTerm);
    }
}
