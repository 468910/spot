package ica.han.DataSource.Database;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Song;
import Domain.DomainObjects.Track;
import Domain.DomainObjects.Video;
import ica.han.DataSource.Helpers.SQLStoredProcedures;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by apple on 29/11/15.
 */
public class TrackSQLDataSource extends SQLDataSource   {


    public TrackSQLDataSource(Connection connection){
        super(connection);
    }

    public List find(String query) {
        ResultSet rs = executeQuery("SELECT * FROM " + Track.class.getSimpleName());

        List list = new ArrayList();
        try {
            while (rs.next()) {
                Track track = (Track)rowToObject(rs);
                list.add(track);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Hier is de searchterm" + query);

        return list;
    }

    public void insert(Entity entity) {
        try {
        PreparedStatement statement = connection.prepareStatement(SQLStoredProcedures.INSERT_TRACK);

            statement.setString(1, ((Track)entity).getPerformer());
            statement.setString(2, ((Track)entity).getTitle());
            statement.setString(3, ((Track)entity).getUrl());
            statement.setLong(4, ((Track) entity).getDuration());

            if(entity instanceof Video){

                statement.setInt(5, ((Video)entity).getPlayCount());

                Calendar calendar =((Video) entity).getPublicationDate();

                statement.setDate(6, (new Date(calendar.getTimeInMillis())));
                statement.setString(7, ((Video) entity).getDescription());
                statement.setString(8, null);

            }else if(entity instanceof Song){
                statement.setInt(5, 0);
                statement.setDate(6, null);
                statement.setString(7, null);
                statement.setString(8,((Song)entity).getAlbum());

            }else{
                System.out.println("Error");
            }
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Entity entity) {

    }

    public void update(Entity entity) {

    }

    protected Entity rowToObject(ResultSet rs) throws SQLException {
        Track track;
        String album = rs.getString("album");
        if(album.isEmpty()){
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

        track.setTitle(rs.getString("title"));
        track.setUrl(rs.getString("url"));
        track.setPerformer(rs.getString("performer"));
        track.setDuration(rs.getInt("duration"));

        return track;
    }
}
