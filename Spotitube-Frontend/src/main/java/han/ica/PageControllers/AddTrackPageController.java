package han.ica.PageControllers;

import Domain.DomainObjects.Track;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import han.ica.Model.PlaylistModel;
import han.ica.Model.TrackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Singleton
public class AddTrackPageController extends HttpServlet {

    private final TrackModel trackModel;
    private final PlaylistModel playlistModel;

    @Inject
    public AddTrackPageController(TrackModel trackModel, PlaylistModel playlistModel){
        this.trackModel = trackModel;
        this.playlistModel = playlistModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //set playlistname in h1 element
        String playListName   = req.getParameter("playlistName");
        System.out.println(playListName);
        String[] tracksInList = req.getParameter("tracksInList").split("[\\W]");

        if(req.getParameter("searchTrack") != null){
            req.setAttribute("playlistName", playListName);
            req.setAttribute("tracksInList", tracksInList);
        }


        trackModel.getTracks("goedemorgen");
        trackModel.getTracks("Zondag");


        //set tracks to list
        req.setAttribute("list", trackModel.tracks);

        //use this view in /addtrack
        req.getRequestDispatcher("tracks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getRequestDispatcher("tracks.jsp").forward(req, resp);
    }
}
