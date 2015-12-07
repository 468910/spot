package ica.han.DataSource.Database;

import Domain.DomainObjects.Entity;
import ica.han.DataSource.DAO.DAOManager;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by apple on 03/10/15.
 * Opdract Requirement 1
 */
public interface IDataSource {

    List find(String query);

    void insert(Entity entity);

    void delete(Entity entity);

    void update(Entity entity);

}
