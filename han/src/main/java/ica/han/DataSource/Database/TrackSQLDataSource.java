package ica.han.DataSource.Database;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Track;
import ica.han.DataSource.Helpers.SQLStoredProcedures;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            statement.setString(2, ((Track) entity).getTitle());
            statement.setString(3, ((Track) entity).getUrl());
            statement.setLong(4, ((Track)entity).getDuration());
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
        Track track = new Track();
        track.setId(rs.getInt("TrackPOID"));
        track.setDuration(rs.getInt("duration"));
        track.setPerformer(rs.getString("performer"));
        track.setTitle(rs.getString("title"));
        track.setUrl(rs.getString("url"));

        return track;
    }
}
