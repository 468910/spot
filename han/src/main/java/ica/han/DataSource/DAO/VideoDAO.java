package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import ica.han.DataSource.Database.IDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 04/10/15.
 */
public class VideoDAO extends DAO {


    @Override
    public List GetList() {
        return null;
    }

    public VideoDAO(IDataSource dataSource) {
        super(dataSource);
    }


}
