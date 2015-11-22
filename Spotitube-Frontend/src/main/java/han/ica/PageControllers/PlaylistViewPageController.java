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
    @Inject
    public PlaylistViewPageController(PlaylistModel playlistModel){
        this.playlistModel = playlistModel;
    }


    List<Playlist> playlists = new ArrayList<>();
    MyBean myBean = new MyBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      // playlistModel.getAllPlaylists(abonnee);
        req.setAttribute("list", playlists);


        //TODO: Apparently i can only set values in the jsp file throug the doGet... :'( Im gonna sleep now.
        req.setAttribute("myBean", prap);

        req.getRequestDispatcher("playlist.jsp").forward(req, resp);
        System.out.println(playlistModel.playlists.isEmpty());
        System.out.println(playlistModel.playlists.size());
        //System.out.println(getServletContext().getRealPath("/"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("submitTrack") != null){
            playlists.add(new Playlist(2, abonnee, req.getParameter("newPlaylistName")));
            resp.sendRedirect("playlist");
        }

        if(req.getParameter("editThisList") != null){
            System.out.println("yoyo: " + req.getParameter("radioButton"));
            resp.sendRedirect("playlist");
            req.setAttribute("myBean", req.getParameter("radioButton"));

            prap = req.getParameter("radioButton");

        }

        //i stranded here. How do i send value's to the jsp file?
        if(req.getParameter("choosePlaylistButton") != null){

            resp.sendRedirect("playlist");
            
        }
    }
}

