package han.ica.PageControllers;

import Domain.DomainObjects.Track;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import han.ica.Model.TrackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by apple on 16/10/15.
 */
@Singleton
public class AddTrackPageController extends HttpServlet {


    private final TrackModel trackModel;


    @Inject
    public AddTrackPageController(TrackModel trackModel){
        this.trackModel = trackModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ArrayList<Track> tracks = (ArrayList)trackModel.getTracks("placeholder");

        req.setAttribute("list", tracks);

        req.getRequestDispatcher("tracks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getRequestDispatcher("tracks.jsp").forward(req, resp);
    }


}
