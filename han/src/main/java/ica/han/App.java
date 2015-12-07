package ica.han;

import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Song;
import Domain.DomainObjects.Video;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.DAO.PlaylistDAO;
import ica.han.DataSource.DAO.SongDAO;
import ica.han.DataSource.DAO.TrackDAO;
import ica.han.DataSource.Database.PlaylistSQLDataSource;
import ica.han.DataSource.Database.SongSQLDataSource;

import java.util.ArrayList;
import java.util.Calendar;
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
       // List<Playlist> list = dao.GetListByOwner("betty");
        /*
        list.stream().forEach((Playlist) -> {
            System.out.println(Playlist.getOwner());
            System.out.println(Playlist.getName());
            System.out.println(Playlist.getTracks().size());
        });*/


        //dao.insert(new Playlist(1, "Jaapie", "test"));
        Playlist playlist = new Playlist(1, "betty", "Test");
        playlist.setId(1);
        dao.insert(playlist);


        TrackDAO trackDAO = (TrackDAO) new DAOManager().getDAO(DAOManager.Table.Track);

        Song song = new Song();
        song.setAlbum("Testalbum");
        song.setDuration(8);
        song.setPerformer("Klaas");
        song.setTitle("yoope");
        song.setUrl("Http://google.com");


        Video video = new Video();
        video.setDescription("Dit is een mooie video");
        video.setPlayCount(9001);
        video.setPublicationDate(Calendar.getInstance());
        video.setPerformer("De kat van de buren");
        video.setDuration(9);
        video.setTitle("Grappig homevideo");
        video.setUrl("http://ergens.nl");
        video.setTitle("Lachende Kat");


        ArrayList<Song> anouks = new ArrayList<>();

        Song anouk = new Song();
        anouk.setTitle("U Being Me");
        anouks.add(anouk);

        Song anouk2 = new Song();
        anouk2.setTitle("Cry");
        anouks.add(anouk2);


        // JAVA 8
        anouks.stream().forEach((Song) -> {
            Song.setAlbum("Urban Solitude");
            Song.setDuration(100);
            Song.setUrl("http://spot/UrbanSolitude");
            Song.setPerformer("Anouk");
            trackDAO.insert(Song);
        });



        trackDAO.insert(video);
        trackDAO.insert(song);

        List list = dao.GetListByOwner("ANY");
        System.out.println(list.size());



        SongDAO songDAO = (SongDAO) new DAOManager().getDAO(DAOManager.Table.Song);



    }

}
