package ica.han;

import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Song;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.DAO.PlaylistDAO;
import ica.han.DataSource.DAO.SongDAO;
import ica.han.DataSource.DAO.TrackDAO;
import ica.han.DataSource.Database.PlaylistSQLDataSource;
import ica.han.DataSource.Database.SongSQLDataSource;

import java.util.List;

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
        //dao.insert(new Playlist(1, "Jaapie", "test"));
        Playlist playlist = new Playlist(1, "betty", "Test");
        playlist.setId(1);
        dao.update(playlist);


        TrackDAO trackDAO = (TrackDAO) new DAOManager().getDAO(DAOManager.Table.Track);

        Song song = new Song();
        song.setAlbum("Testalbum");
        song.setDuration(8);
        song.setPerformer("Klaas");
        song.setTitle("yoope");
        song.setUrl("Http://google.com");

        trackDAO.insert(song);

        List list = dao.GetListByOwner("ANY");
        System.out.println(list.size());



        SongDAO songDAO = (SongDAO) new DAOManager().getDAO(DAOManager.Table.Song);






    }

}
