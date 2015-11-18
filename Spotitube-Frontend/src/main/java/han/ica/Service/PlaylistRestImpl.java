package han.ica.Service;


import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import Domain.Service.PlaylistService;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by apple on 21/10/15.
 */
public class PlaylistRestImpl implements PlaylistService {

    private String baseurl = "http://127.0.0.1:8080/han/rest/";

    @Override
    public void updatePlayList(Playlist playlist) {

    }

    @Override
    public List<Playlist> getPlaylists(String owner) {
       Client client =  ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/" + owner);
        return target.request(MediaType.APPLICATION_JSON).get(List.class);

    }

    public void addPlaylist(Playlist playlist) {
        Client client = ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/i");
        target.request(MediaType.APPLICATION_JSON).post(Entity.json(playlist), Playlist.class);
    }

    @Override
    public List<Track> getAllTracks(String searchTerm) {
        Client client = ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/track/{" + searchTerm + "}");
        return target.request(MediaType.APPLICATION_JSON).get(List.class);
    }
}
