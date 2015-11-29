package han.ica.PageControllers;


import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import han.ica.Model.PlaylistModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Singleton // Required
public class PlaylistViewPageController extends HttpServlet {
    private final String abonnee = "betty"; //of abonnee: test
    private final PlaylistModel playlistModel;
    public String playlistName = "";
    public String playlistID = "";

    @Inject
    public PlaylistViewPageController(PlaylistModel playlistModel){
        this.playlistModel = playlistModel;
    }

    /*
        TODO: Playlist aanmaken
        TODO: Playlist naam aanpassen
        TODO: Nummers toevoegen in playlist
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        playlistModel.getAllPlaylists(abonnee);
        req.setAttribute("list", playlistModel.playlists);

        /* To get the parameters from the playlist table
         */
        req.setAttribute("myBean", playlistName);
        req.setAttribute("playlistID", playlistID);

        req.getRequestDispatcher("playlist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Add a new playlist to the database
         */
        if(req.getParameter("submitList") != null){
            System.out.println("Adding a new playlist: " + req.getParameter("newPlaylistName"));
            playlistModel.insert(new Playlist(2, abonnee, req.getParameter("newPlaylistName")));
            resp.sendRedirect("playlist");
        }

        /* Set the values which are needed in the /addTrack page
         */
        if(req.getParameter("editThisList") != null){
            playlistName = req.getParameter("radioButton");
            playlistID = req.getParameter("listID");
            resp.sendRedirect("playlist");
        }

        /* Change the playlist name
            TODO: Not implemented yet
         */
        if (req.getParameter("changeListName") != null) {

//            for(int i = 0; i < playlistModel.playlists.size(); i++){
//                if(playlistModel.playlists.get(i).getId() == playlistID){
//
//                }
//            }
            Playlist eenplaylist = playlistModel.playlists.get(4);
            eenplaylist.setName(req.getParameter("newTrackName"));
            playlistModel.update(eenplaylist);
            resp.sendRedirect("playlist");
        }

        /* To redirect to /addTrack
         */
        if(req.getParameter("searchTrack") != null){
            resp.sendRedirect("addtrack");
        }
    }
}

