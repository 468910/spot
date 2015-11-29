package han.ica.Service;

import Domain.DomainObjects.Availability;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import Domain.Service.PlaylistService;

import java.util.List;

/**
 * Created by apple on 27/10/15.
 */
public class PlaylistSeviceImpl implements PlaylistService {

        @Override
        public void updatePlayList(Playlist playlist) {

        }

        @Override
        public List<Playlist> getPlaylists(String owner) {
                return null;
        }

        @Override
        public void addTrack(Availability availability) {

        }

        @Override
        public void addPlaylist(Playlist playlist) {

        }

        @Override
        public List<Track> getAllTracks(String searchTerm) {
                return null;
        }
}
