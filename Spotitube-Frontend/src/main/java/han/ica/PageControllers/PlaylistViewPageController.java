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

    //Karel
    private final String abonnee = "test";
    private final PlaylistModel playlistModel;

    public String playlistName = "";
    public int radId;
    @Inject
    public PlaylistViewPageController(PlaylistModel playlistModel){
        this.playlistModel = playlistModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        playlistModel.getAllPlaylists(abonnee);
        req.setAttribute("list", playlistModel.playlists);

        //To set the playlistname which will be eddited later.
        req.setAttribute("myBean", playlistName);

        List<String> tracksInList = new ArrayList<>();
//        for(int j = 0; j < playlistModel.playlists.size(); j++) {
//            if(playlistModel.playlists.get(j).getName() == playlistName ) {
                for (int i = 0; i < playlistModel.playlists.get(1).getTracks().size(); i++) {
                    System.out.println("lets add some tracks" + playlistModel.playlists.get(1).getTracks().get(i).getTitle());
                    tracksInList.add(playlistModel.playlists.get(1).getTracks().get(i).getTitle());
                    System.out.println("tracks:: " + tracksInList);
                    req.setAttribute("tracks", tracksInList);
                }
//            }
//        }

        //User this view on /playlist
        req.getRequestDispatcher("playlist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //To add a new playlist
        if(req.getParameter("submitTrack") != null){
            playlistModel.insert(new Playlist(2, abonnee, req.getParameter("newPlaylistName")));
            resp.sendRedirect("playlist");
        }

        //Set playlistName to current name to be used in next ifstatement
        if(req.getParameter("editThisList") != null){

            playlistName = req.getParameter("radioButton");

            req.setAttribute("myBean", playlistName);
            resp.sendRedirect("playlist");
        }

        //Changing the chosen playlistname
        if (req.getParameter("changeListName") != null) {
            for (Playlist playlist : (ArrayList<Playlist>)playlistModel.playlists ) {
                if (playlist.getName().equals(playlistName)) {
                    playlist.setName(req.getParameter("newTrackNamet"));
                }
            }
        }

        //Go to /addtrack
        if(req.getParameter("searchTrack") != null){
            System.out.println(" the number of tracks " + playlistModel.playlists.get(0).getTracks().size());
            resp.sendRedirect("addtrack");
        }

        //go to /playlist
        if(req.getParameter("choosePlaylistButton") != null){
            resp.sendRedirect("playlist");
        }
    }
}

