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
import java.util.List;

@Singleton
public class AddTrackPageController extends HttpServlet {

    private final TrackModel trackModel;

    @Inject
    public AddTrackPageController(TrackModel trackModel){
        this.trackModel = trackModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Track> tracks = new ArrayList<>();

        tracks.add(new Track());
        tracks.get(0).setTitle("track0");
        tracks.get(0).setPerformer("zanger0");
        tracks.get(0).setId(0);
        tracks.get(0).setUrl("url0");
        tracks.get(0).setDuration(20);
        tracks.add(new Track());
        tracks.get(1).setTitle("track1");
        tracks.get(1).setPerformer("zanger1");
        tracks.get(1).setId(1);
        tracks.get(1).setUrl("url1");
        tracks.get(1).setDuration(20);
        tracks.add(new Track());
        tracks.get(2).setTitle("track2");
        tracks.get(2).setPerformer("zanger2");
        tracks.get(2).setId(2);
        tracks.get(2).setUrl("url2");
        tracks.get(2).setDuration(20);

        //set playlistname in h1 element
        if(req.getParameter("searchTrack") != null){
            req.setAttribute("playlistName", req.getParameter("searchTrack"));
        }

        trackModel.getTracks("goedemorgen");

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
