package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Track;
import ica.han.DataSource.Database.IDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 04/10/15.
 */
public class TrackDAO extends DAO {



    public List findByTitle(String searchTerm){
       return dataSource.find(searchTerm);
    }


    @Override
    public List GetList() {
        return null;
    }

    public TrackDAO(IDataSource dataSource) {
        super(dataSource);
    }


}
