package ica.han.DataSource.Database;

import Domain.DomainObjects.*;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.Helpers.SQLStoredProcedures;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by apple on 28/11/15.
 */
public class PlaylistSQLDataSource extends SQLDataSource{


    public PlaylistSQLDataSource(Connection connection){
        super(connection);
    }


    public List find(String query) {

        ResultSet resultset = executeQuery("SELECT * FROM Playlist");
        List list = resultSetToList(resultset);

        for(Playlist p : (ArrayList<Playlist>)list){
            ResultSet rs = (executeQuery("SELECT * FROM Availability INNER JOIN Playlist on PlaylistPOID = FK_PlaylistPOID " +
                    "INNER JOIN Track on TrackPOID = FK_TrackPOID Where owner = '" + p.getOwner() + "'"));
            try{


                while(resultset.next()) {
                    Track track;
                    String album = rs.getString("album");
                    if(album == null){
                        track = new Video();
                        ((Video)track).setDescription(rs.getString("description"));
                        ((Video)track).setPlayCount(rs.getInt("playcount"));

                        // Converting Date to Calendar
                        java.sql.Date date = rs.getDate("publicationdate");
                        Calendar calendar = new GregorianCalendar();
                        calendar.setTime(date);
                        ((Video) track).setPublicationDate(calendar);
                    }else{
                        track = new Song();
                        ((Song)track).setAlbum(rs.getString("album"));
                    }

                    System.out.println("Track ADDDEDE");
                    track.setTitle(rs.getString("title"));
                    track.setUrl(rs.getString("url"));
                    track.setPerformer(rs.getString("performer"));
                    track.setDuration(rs.getInt("duration"));

                    p.add(track);
                }}catch (Exception e){
                e.printStackTrace();
            }
        }


        return list;
    }

    protected List resultSetToList(ResultSet rs){
        List list = new ArrayList();
        try {
            while (rs.next()) {
                Playlist playList = (Playlist)rowToObject(rs);
                list.add(playList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    protected Entity rowToObject(ResultSet rs) throws SQLException {
        Playlist playList = new Playlist();
        playList.setId(rs.getInt("PlaylistPOID"));
        playList.setName(rs.getString("name"));
        playList.setOwner(rs.getString("owner"));
        return playList;
    }

    public void insert(Entity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLStoredProcedures.INSERT_PLAYLIST);
            statement.setString(2, ((Playlist) entity).getName());
            statement.setString(1, ((Playlist) entity).getOwner());
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Entity entity) {

    }

    public void update(Entity entity) {
        try{
            PreparedStatement statement = connection.prepareStatement(SQLStoredProcedures.UPDATE_Playlist);
            statement.setInt(3, entity.getId());
            System.out.println(entity.getId());
            statement.setString(2, ((Playlist) entity).getName());
            System.out.println(((Playlist) entity).getName());
            statement.setString(1, ((Playlist) entity).getOwner());
            System.out.println(((Playlist) entity).getOwner());
                    statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
