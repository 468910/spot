package Domain.Service;


import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;

import java.util.List;

public interface PlaylistService {

    void updatePlayList(Playlist playlist);

    List<Playlist> getPlaylists(String owner);

    void addTrack(Playlist playlist, Track track);

    void addPlaylist(Playlist playlist);

    List<Track> getAllTracks(String searchTerm);

}
