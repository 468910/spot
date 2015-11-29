package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import com.google.inject.Inject;
import ica.han.DataSource.Database.IDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 03/10/15.
 */
public abstract class DAO {

    public abstract List GetList();

    public void insert(Entity entity) {
        dataSource.insert(entity);
    }


    public void update(Entity object) {
        dataSource.update(object);
    }


    public void delete(Entity object) {
        dataSource.delete(object);
    }

    protected IDataSource dataSource;

    @Inject
    public DAO(IDataSource dataSource) {
        this.dataSource = dataSource;

    }

}
