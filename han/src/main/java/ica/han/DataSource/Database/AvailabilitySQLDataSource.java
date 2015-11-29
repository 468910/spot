package ica.han.DataSource.Database;

import Domain.DomainObjects.Availability;
import Domain.DomainObjects.Entity;
import ica.han.DataSource.Helpers.SQLStoredProcedures;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by apple on 29/11/15.
 */
public class AvailabilitySQLDataSource extends SQLDataSource {

    public AvailabilitySQLDataSource(Connection connection) {
        super(connection);
    }

    public List find(String query) {
        return null;
    }

    public void insert(Entity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLStoredProcedures.INSERT_LINK);
            statement.setInt(2, ((Availability)entity).getPlaylist_Id());
            statement.setInt(1, ((Availability) entity).getTrack_Id());
            statement.setBoolean(3, ((Availability) entity).isOfflineAvailable());
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Entity entity) {

    }

    public void update(Entity entity) {

    }
}
