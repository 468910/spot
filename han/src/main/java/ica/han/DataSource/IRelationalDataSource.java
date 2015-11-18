package ica.han.DataSource;

import Domain.DomainObjects.Entity;

import java.sql.ResultSet;

/**
 * Created by apple on 03/10/15.
 */
public interface IRelationalDataSource {

    ResultSet getResultSet();

    ResultSet find(String pattern);

    void create();

    void insert(Entity object);

    void delete(Entity object);

    void update(Entity object);

}
