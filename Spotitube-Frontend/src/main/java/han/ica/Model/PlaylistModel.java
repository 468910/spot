package han.ica.Model;

import Domain.DomainObjects.Availability;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import Domain.Service.PlaylistService;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/10/15.
 */
public class PlaylistModel {

    private final PlaylistService playlistService;
    public List<Playlist> playlists  = new ArrayList<Playlist>();

    @Inject
    public PlaylistModel(PlaylistService playlistService){
        this.playlistService = playlistService;
    }


    public void getAllPlaylists(String owner) {
        playlists = playlistService.getPlaylists(owner);
    }

    public void insert(Playlist playlist){
        playlistService.addPlaylist(playlist);
    }

    public void update(Playlist playlist) {
        playlistService.updatePlayList(playlist);
    }

    public void addTrack(Availability availability) {
        playlistService.addTrack(availability);
    }

}
