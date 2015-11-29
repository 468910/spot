package ica.han.DataSource.Database;

import Domain.DomainObjects.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by apple on 29/11/15.
 */
public abstract class SQLDataSource implements IDataSource {

    protected Connection connection;


    public SQLDataSource(Connection connection){
        this.connection = connection;
    }


    protected ResultSet executeQuery(String query){
        ResultSet resultSet;
        try{
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet;
        }catch (Exception e){

            e.printStackTrace();
        }
        return null;
    }

    public abstract List find(String query);

    public abstract void insert(Entity entity);

    public abstract void delete(Entity entity);

    public abstract void update(Entity entity);
}
