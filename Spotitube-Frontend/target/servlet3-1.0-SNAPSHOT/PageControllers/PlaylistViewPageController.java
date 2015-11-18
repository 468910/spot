package han.ica.PageControllers;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import han.ica.Model.Domain.Playlist;
import han.ica.Model.PlaylistModel;
import han.ica.View.PlaylistView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet
@Singleton // Required
public class PlaylistViewPageController extends HttpServlet {

    @Inject
    PlaylistModel playlistModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       playlistModel.getAllPlaylists("test");

        req.setAttribute("playlist", playlistModel.playlists.get(0));

        req.getRequestDispatcher("playlist.jsp").forward(req, resp);

        System.out.println(getServletContext().getRealPath("/"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("button1") != null){
            System.out.println("butttonz");

        }
    }
}
