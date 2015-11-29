package ica.han.DataSource.DAO;

import com.google.inject.Singleton;
import ica.han.DataSource.Database.*;
import ica.han.DataSource.Helpers.SQLTableStatements;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

/**
 * Created by apple on 04/10/15.
 */
@Singleton
public class DAOManager {

    private  Connection connection;
    private String DATABASE_PROPERTIES_FILE_NAME = "Database.properties";



    public DAOManager(){
        setup();
    }

    public void setup() {
        try {
            System.out.println(System.getProperty("user.dir"));
            System.out.println(new File(".").getCanonicalPath());
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                Properties properties = new Properties();
                properties.load(classLoader.getResourceAsStream(DATABASE_PROPERTIES_FILE_NAME));

                connection = DriverManager.getConnection(properties.getProperty("dburl"),
                        properties.getProperty("user"),
                        properties.getProperty("password"));

            setupTables();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setupTables(){
        try {

            Statement statement = connection.createStatement();
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "Playlist", null);
            if(tables.next()){
            }else {
                for(Field field : SQLTableStatements.class.getDeclaredFields()){
                    field.setAccessible(true);
                    System.out.println(field.get(SQLTableStatements.class));
                    connection.createStatement().executeUpdate((String)field.get(SQLTableStatements.class));
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //TODO
    public DAO getDAO(Table table){
        return table.getDAO(connection);
    }




    public enum Table{
        Playlist() {
            @Override
            protected DAO getDAO(Connection connection)
            {
                return new PlaylistDAO(new PlaylistSQLDataSource(connection));
            }
        },
        Song() {
            @Override
            protected DAO getDAO(Connection connection) {
                return new SongDAO(new SongSQLDataSource(connection));
            }
        },
        Track() {
            @Override
            protected DAO getDAO(Connection connection){
               return new TrackDAO(new TrackSQLDataSource(connection));
            }
        },
        Video() {
            @Override
            protected DAO getDAO(Connection connection){
                return new VideoDAO(new VideoSQLDataSource(connection));
            }
        },
        Availability(){
            @Override
            protected DAO getDAO(Connection connection){
                return new AvailabilityDAO(new AvailabilitySQLDataSource(connection));
            }
        };

        protected abstract DAO getDAO(Connection connection);


    }


}
