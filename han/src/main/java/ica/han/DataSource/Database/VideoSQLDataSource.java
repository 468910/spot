package ica.han.DataSource.Database;

import Domain.DomainObjects.Entity;

import java.sql.Connection;
import java.util.List;

/**
 * Created by apple on 29/11/15.
 */
public class VideoSQLDataSource extends SQLDataSource {

    public VideoSQLDataSource(Connection connection) {
        super(connection);
    }

    @Override
    public List find(String query) {
        return null;
    }

    @Override
    public void insert(Entity entity) {

    }

    @Override
    public void delete(Entity entity) {

    }

    @Override
    public void update(Entity entity) {

    }
}
