package han.ica.Service;


import Domain.DomainObjects.*;
import Domain.Service.PlaylistService;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 21/10/15.
 */
public class PlaylistRestImpl implements PlaylistService {

    private String baseurl = "http://127.0.0.1:8080/han/rest/";

    @Override
    public void updatePlayList(Playlist playlist) {
        Client client = ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/updateplaylist");
        target.request(MediaType.APPLICATION_JSON).post(Entity.json(playlist), Playlist.class);
    }

    @Override
    public List<Playlist> getPlaylists(String owner) {
       Client client =  ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/" + owner);

        Response response = target.request(MediaType.APPLICATION_JSON).get();

        JsonArray array;
        List<Playlist> playlists = new ArrayList<Playlist>();
        //Se Response.Status.OK;
        if (response.getStatus() == 200) {
            StringReader stringReader = new StringReader(target.request(MediaType.APPLICATION_JSON).get(String.class));
            try (JsonReader jsonReader = Json.createReader(stringReader)) {
                array = jsonReader.readArray();


                for(int i = 0; i < array.size(); i++){
                    Playlist playlist = new Playlist();
                    JsonObject jsonPlaylist = array.getJsonObject(i);

                    JsonArray jsonTracks = jsonPlaylist.getJsonArray("tracks");

                    System.out.println(jsonTracks.size());
//                    if(jsonTracks.size() > 0) {
                        for(int j = 0; j < jsonTracks.size(); j++){
                            JsonObject jsonTrack = jsonTracks.getJsonObject(j);
                            playlist.add(mapToTrack(jsonTrack));
                        }
//                    }


                    playlist.setOwner(jsonPlaylist.getString("owner"));
                    playlist.setName(jsonPlaylist.getString("name"));
                    playlist.setId(jsonPlaylist.getInt("id"));
                    playlists.add(playlist);
                }


            }
        }

        return playlists;

    }

    private Track mapToTrack(JsonObject jsonObject){
        Track track = new Track();

        String album = jsonObject.getString("album");
        if(jsonObject.getString("type").equals("Video")){
            track = new Video();
            ((Video)track).setDescription(jsonObject.getString("description"));
            ((Video)track).setPlayCount(jsonObject.getInt("playCount"));
            ((Video)track).setPublicationDate(null);
        }else{
            track = new Song();
            ((Song)track).setAlbum(jsonObject.getString("album"));
        }
        track.setId(jsonObject.getInt("id"));
        track.setDuration(jsonObject.getInt("duration"));
        track.setPerformer(jsonObject.getString("performer"));
        track.setTitle(jsonObject.getString("title"));
        track.setUrl(jsonObject.getString("url"));
//        System.out.println("SGESEGESGSEGSEGRSGDFZBDRNHZREGDRBZRDBR");
//        System.out.println(jsonObject.getInt("id"));
//        System.out.println(jsonObject.getInt("duration"));
//        System.out.println(jsonObject.getString("performer"));
//        System.out.println(jsonObject.getString("title"));
//        System.out.println(jsonObject.getString("url"));
        return track;
    }



    @Override
    public void addTrack(Availability availability) {
        Client client = ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/addtrack");
        target.request(MediaType.APPLICATION_JSON).post(Entity.json(availability), Availability.class);
    }



    public void addPlaylist(Playlist playlist) {
        Client client = ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/i");
        target.request(MediaType.APPLICATION_JSON).post(Entity.json(playlist), Playlist.class);
    }

    @Override
    public List<Track> getAllTracks(String searchTerm) {
        Client client = ClientBuilder.newClient().register(JacksonFeature.class);
        WebTarget target = client.target(baseurl + "playlists/tracks/" + searchTerm);
        //target.getUriBuilder().path("{searchTerm}").build(searchTerm);
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Track>>(){});
    }
}
