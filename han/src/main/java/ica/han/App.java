package ica.han;

import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.DAO.PlaylistDAO;
import ica.han.DataSource.DAO.TrackDAO;
import ica.han.Domain.POJO.Server;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlaylistDAO dao = (PlaylistDAO) new DAOManager().getDAO(DAOManager.Table.Playlist);
        dao.update(new Playlist(1, "Jaapie", "test"));
        dao.update(new Playlist(2, "GVD", "yay"));

        TrackDAO trackDAO = (TrackDAO) new DAOManager().getDAO(DAOManager.Table.Track);

       /* trackDAO.insert(new Track("Geweldige jan", "Zondag", "?", 1));
        trackDAO.insert(new Track("Geweldige jan", "Goedemorgen", "?", 1));
        trackDAO.insert(new Track("Geweldige jan", "Als ik jou niet had", "?", 1));
        trackDAO.insert(new Track("Geweldige jan", "Ik ben gelukkig", "?", 1));*/





    }

}
