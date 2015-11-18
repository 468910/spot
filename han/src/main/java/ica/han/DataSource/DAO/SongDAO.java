package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Song;
import com.google.inject.Inject;
import ica.han.DataSource.IRelationalDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 04/10/15.
 */
public class SongDAO extends DAO {

    public List GetList() {
        ResultSet rs = dataSource.getResultSet();
        List list = new ArrayList();
        try {
            while (rs.next()) {
                Song song = (Song)rowToObject(rs);

                list.add(song);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }


    @Override
    protected Entity rowToObject(ResultSet rs) throws SQLException {
        Song song = new Song();
        song.setAlbum(rs.getString("album"));
        return song;
    }

    public SongDAO(IRelationalDataSource dataSource) {
        super(dataSource);
    }
}
