package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import ica.han.DataSource.IRelationalDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 04/10/15.
 */
public class VideoDAO extends DAO {
    @Override
    List<Entity> GetList() {
        return null;
    }




    @Override
    protected Entity rowToObject(ResultSet rs) throws SQLException {
        return null;
    }

    public VideoDAO(IRelationalDataSource dataSource) {
        super(dataSource);
    }


}
