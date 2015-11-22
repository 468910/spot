package ica.han;

import Domain.DomainObjects.Playlist;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.DAO.PlaylistDAO;
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
        dao.insert(new Playlist(1, "test", "test"));
        dao.insert(new Playlist(2, "yay", "yay"));




    }

}
