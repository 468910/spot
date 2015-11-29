package ica.han.DataSource.Database;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 29/11/15.
 */
public class SongSQLDataSource extends SQLDataSource {

    public SongSQLDataSource(Connection connection){
       super(connection);
    }

    public List find(String query) {
        return null;
    }

    public void insert(Entity entity) {

    }

    public void delete(Entity entity) {

    }

    public void update(Entity entity) {

    }

    protected Entity rowToObject(ResultSet rs) throws SQLException {
        Song song = new Song();
        song.setAlbum(rs.getString("album"));
        return song;
    }


}
