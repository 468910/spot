package ica.han.Domain.REST;

import Domain.DomainObjects.Availability;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import Domain.Service.PlaylistService;
import ica.han.DataSource.DAO.AvailabilityDAO;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.DAO.PlaylistDAO;
import ica.han.DataSource.DAO.TrackDAO;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by apple on 03/10/15.
 */
@Path("/playlists")
public class PlaylistServiceRestImpl implements PlaylistService {


    private final DAOManager daoManager = new DAOManager();

    /**@Inject
    public PlaylistServiceRestImpl(DAOManager daoManager){
        this.daoManager = daoManager;
    }**/


    @Path("/updateplaylist")
    @POST
    @Consumes("application/json")
    public void updatePlayList(Playlist playlist) {
        ((PlaylistDAO)daoManager.getDAO(DAOManager.Table.Playlist)).update(playlist);
    }

    @Path("/{owner}")
    @GET
    @Produces("application/json")
    public List<Playlist> getPlaylists(@PathParam("owner")String owner)
    {
        System.out.println(owner);
        return ((PlaylistDAO)daoManager.getDAO(DAOManager.Table.Playlist)).GetListByOwner(owner);
    }

    @Path("/addtrack")
    @POST
    @Consumes("application/json")
    public void addTrack(Availability availability) {
        System.out.println("Adding track to playlist");

        ((AvailabilityDAO)daoManager.getDAO(DAOManager.Table.Availability)).insert(availability);
    }

    @Path("/i")
    @POST
    @Consumes("application/json")
    public void addPlaylist(Playlist playlist) {
        ((PlaylistDAO)daoManager.getDAO(DAOManager.Table.Playlist)).insert(playlist);
    }

    @Path("/tracks/{searchTerm}")
    @GET
    @Produces("application/json")
    public List<Track> getAllTracks(@PathParam("searchTerm")String searchTerm) {
        return ((TrackDAO)daoManager.getDAO(DAOManager.Table.Track)).findByTitle(searchTerm);
    }



}
