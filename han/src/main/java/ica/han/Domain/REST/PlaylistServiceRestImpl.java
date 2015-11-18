package ica.han.Domain.REST;

import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import Domain.Service.PlaylistService;
import com.google.inject.Inject;
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


    public void updatePlayList(Playlist playlist) {

    }
    @Path("/{owner}")
    @GET
    @Produces("application/json")
    public List<Playlist> getPlaylists(@PathParam("owner")String owner)
    {
        System.out.println(owner);
        return ((PlaylistDAO)daoManager.getDAO(DAOManager.Table.Playlist)).GetListByOwner(owner);
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
