package han.ica.PageControllers;


import Domain.DomainObjects.Playlist;
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

@Singleton // Required
public class PlaylistViewPageController extends HttpServlet {

    private final String abonnee = "test";
    private final PlaylistModel playlistModel;

    public String prap = "";
    public int radId;
    @Inject
    public PlaylistViewPageController(PlaylistModel playlistModel){
        this.playlistModel = playlistModel;
    }


    List<Playlist> playlists = new ArrayList<>();
    MyBean myBean = new MyBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", playlists);

        //To set the playlistname which will be eddited later.
        req.setAttribute("myBean", prap);

        //User this view on /playlist
        req.getRequestDispatcher("playlist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //To add a new playlist
        if(req.getParameter("submitTrack") != null){
            playlists.add(new Playlist(2, abonnee, req.getParameter("newPlaylistName")));
            resp.sendRedirect("playlist");
        }

        //Set prap to current name to be used in next ifstatement
        if(req.getParameter("editThisList") != null){
            resp.sendRedirect("playlist");

            prap = req.getParameter("radioButton");
            req.setAttribute("myBean", prap);
        }

        //Changing the chosen playlistname
        if (req.getParameter("changeListName") != null) {
            for (Playlist playlist : playlists) {
                if (playlist.getName().equals(prap)) {
                    playlist.setName(req.getParameter("newTrackName"));
                    resp.sendRedirect("playlist");
                }
            }
        }

        //Go to /addtrack
        if(req.getParameter("searchTrack") != null){
            resp.sendRedirect("addtrack");
        }

        //go to /playlist
        if(req.getParameter("choosePlaylistButton") != null){
            resp.sendRedirect("playlist");
        }
    }
}

