package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Playlist;
import com.google.inject.Inject;
import ica.han.DataSource.IRelationalDataSource;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 03/10/15.
 */
public class PlaylistDAO extends DAO {

    public PlaylistDAO(IRelationalDataSource dataSource) {
        super(dataSource);
        System.out.println("Her i am");
    }

    public List GetList() {
        ResultSet rs = dataSource.getResultSet();
        List list = resultSetToList(rs);
        return list;

    }

    public List GetListByOwner(String owner){
       ResultSet rs = dataSource.find("SELECT * FROM " + Playlist.class.getSimpleName()
               + " WHERE owner =" + "'" + owner + "'");
        List list = resultSetToList(rs);
        return list;
    }


    @Override
    protected Entity rowToObject(ResultSet rs) throws SQLException {
        Playlist playList = new Playlist();
        playList.setId(rs.getInt("PlaylistPOID"));
        playList.setName(rs.getString("name"));
        playList.setOwner(rs.getString("owner"));
        return playList;
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


}
