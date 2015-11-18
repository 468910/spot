package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Track;
import ica.han.DataSource.IRelationalDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 04/10/15.
 */
public class TrackDAO extends DAO {

    // TODO
    public List GetList() {
        return null ;
    }

    public List findByTitle(String searchTerm){
        ResultSet rs = dataSource.find("SELECT * FROM " + Track.class.getSimpleName()
                + " WHERE title =" + "'" + searchTerm + "'");
        List list = new ArrayList();
        try {
            while (rs.next()) {
                Track track = (Track)rowToObject(rs);
                list.add(track);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected Entity rowToObject(ResultSet rs) throws SQLException {
        Track track = new Track();
        track.setId(rs.getInt("TrackPOID"));
        track.setDuration(rs.getInt("duration"));
        track.setPerformer(rs.getString("performer"));
        track.setTitle(rs.getString("title"));
        track.setUrl(rs.getString("url"));

        return track;
    }

    public TrackDAO(IRelationalDataSource dataSource) {
        super(dataSource);
    }


}
