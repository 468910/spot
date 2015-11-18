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

@Singleton // Required
public class PlaylistViewPageController extends HttpServlet {

    private final String abonnee = "test";
    private final PlaylistModel playlistModel;

    @Inject
    public PlaylistViewPageController(PlaylistModel playlistModel){
        this.playlistModel = playlistModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       playlistModel.getAllPlaylists(abonnee);
        req.setAttribute("list", playlistModel.playlists);

        req.getRequestDispatcher("playlist.jsp").forward(req, resp);
        System.out.println(playlistModel.playlists.isEmpty());
        System.out.println(playlistModel.playlists.size());
        //System.out.println(getServletContext().getRealPath("/"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("button1") != null){
            //req.setAttribute("tracks", playlistModel.playlists.get(0).getTracks());
            //req.getRequestDispatcher("tracks.jsp").forward(req, resp);
            playlistModel.insert(new Playlist(3, req.getParameter("name"), abonnee));
        }

        if(req.getParameter("choosePlaylistButton") != null){
            
        }

        playlistModel.insert(new Playlist(4, req.getParameter("name"), abonnee));

    }
}
