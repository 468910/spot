package ica.han.Domain.REST;

import Domain.DomainObjects.Track;
import Domain.Service.TrackService;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.DAO.TrackDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


/**
 * Created by apple on 29/10/15.
 */
@Path("/track")
public class TrackServiceRestImpl implements TrackService {

   // private TrackDAO trackDAO = (TrackDAO) DAOManager.getInstance().getDAO(DAOManager.Table.Track);

    @Path("/i")
    @GET
    @Produces("application/json")
    public List<Track> getTracks(String title) {
        return null;
    }
}
