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
        /* If searchTrack isn't empty, then set the attribute playlistname to playlistname
         */
        String playListName = req.getParameter("playlistName");
        if(req.getParameter("searchTrack") != null){
            req.setAttribute("playlistName", playListName);
        }
        playlistModel.getAllPlaylists(playListName);

        /* Set the H1 element: ListID to the right id
         */
        int playlistID = Integer.parseInt(req.getParameter("playlistID"));
        req.setAttribute("playlistID", playlistID);

        /* Match playlistID to one of the id's to find the right playlist
         */
        for(int i = 0; i < playlistModel.playlists.size(); i++){
            if(playlistModel.playlists.get(i).getId() == playlistID){
                for(int j = 0; j < playlistModel.playlists.get(i).getTracks().size(); j++){
                    req.setAttribute("list", playlistModel.playlists.get(i).getTracks());
                }
            }
        }

        /* Use this view in /addtrack
         */
        req.getRequestDispatcher("tracks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
