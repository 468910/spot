package han.ica.Service;

import Domain.DomainObjects.Availability;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import Domain.Service.PlaylistService;
import Domain.Service.RemotePlayListService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by apple on 22/10/15.
 */
public class PlaylistServiceRemoteAdapter implements PlaylistService {


    private final RemotePlayListService remotePlayListService;

    @Inject
    public PlaylistServiceRemoteAdapter(RemotePlayListService remotePlayListService){
        this.remotePlayListService = remotePlayListService;

    }

    public void updatePlayList(Playlist playlist) {
        try{
            remotePlayListService.updatePlayList(playlist);
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

    public List<Playlist> getPlaylists(String owner) {
        try{
           return remotePlayListService.getPlaylists(owner);
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addTrack(Availability availability) {

    }




    public void addPlaylist(Playlist playlist) {

    }

    public List<Track> getAllTracks(String searchTerm) {
        return null;
    }
}
