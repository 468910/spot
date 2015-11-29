package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import ica.han.DataSource.Database.IDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 03/10/15.
 */
public class PlaylistDAO extends DAO {

    public PlaylistDAO(IDataSource dataSource) {
        super(dataSource);
        System.out.println("Her i am");
    }

    public List GetList() {
        return dataSource.find("");
    }

    public List GetListByOwner(String owner){
        return  dataSource.find(owner);
    }




}
