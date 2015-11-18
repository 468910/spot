package ica.han.DataSource;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Song;
import Domain.DomainObjects.Track;
import com.google.inject.Singleton;
import ica.han.DataSource.Helpers.SQLTableStatements;

import java.sql.*;

/**
 * Created by apple on 03/10/15.
 */
@Singleton
public class MySqlRelationalDataSource<T> implements IRelationalDataSource {

    private Connection connection;
    final Class<T> typeParameterClass;

    private ResultSetMetaData columns;
    private int columnCount;
    
    public MySqlRelationalDataSource(Connection connection, Class<T> typeParameterClass){
        this.connection = connection;
        this.typeParameterClass = typeParameterClass;
        getColumnInfo();

    }

    public void getColumnInfo(){
       try{
           Statement st = connection.createStatement();
           ResultSet resultSet = st.executeQuery("SELECT * FROM " + typeParameterClass.getSimpleName());
           columns = resultSet.getMetaData();
           columnCount = columns.getColumnCount();
           placeholder();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public PreparedStatement placeholder() throws SQLException{
        String columnPart = "INSERT INTO "  + typeParameterClass.getSimpleName() + " (";
        String valuepart = "VALUES (";
        for(int i = 1; i < columnCount; ++i){
            columnPart += columns.getColumnName(i) + ", ";
            valuepart += "?,";
        }

        String Query = columnPart + columns.getColumnName(columnCount) +") " + valuepart + "?)";
        System.out.println(Query);

        return connection.prepareStatement(Query);
    }

    public PreparedStatement placeholder3(){
        return null;
    }

    public ResultSet getResultSet() {
        ResultSet resultSet;
       try{
           Statement statement = connection.createStatement();
           resultSet = statement.executeQuery("SELECT * FROM " + typeParameterClass.getSimpleName());
            return  resultSet;
       }catch (Exception e){
           resultSet = null;
           e.printStackTrace();
       }

        return  null;
    }

    public ResultSet find(String pattern) {
        ResultSet resultSet;
        try{
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(pattern);
            return resultSet;
        }catch (Exception e){
            resultSet = null;
            e.printStackTrace();
        }
        return null;
    }


    public void create() {
        try {
            Statement statement = connection.createStatement();
            //statement.execute("DROP TABLE " + typeParameterClass.getSimpleName());
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, typeParameterClass.getSimpleName(), null);
            if(tables.next()){

            }else {
                connection.createStatement().executeUpdate(SQLTableStatements.CREATE_TABLE_PLAYLIST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insert(Entity object) {
        try{
            placeholder2(object).executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PreparedStatement placeholder2(Entity entity) throws SQLException{
        PreparedStatement statement = placeholder();

        if(typeParameterClass.getSimpleName().equals("Playlist")) {
            statement.setInt(1, entity.getId());
            statement.setString(2, ((Playlist) entity).getName());
            statement.setString(3, ((Playlist) entity).getOwner());
            return statement;
        }

        if(typeParameterClass.getSimpleName().equals("Song")){
            statement.setInt(1, entity.getId());
            statement.setString(2, ((Song) entity).getAlbum());
            return statement;
        }

        if(typeParameterClass.getSimpleName().equals("Track")){
            statement.setInt(1, entity.getId());
            statement.setString(2, ((Track)entity).getPerformer());
            statement.setString(3, ((Track)entity).getTitle());
            statement.setString(4, ((Track)entity).getUrl());
            statement.setLong(5, ((Track)entity).getDuration());
        }

        if(typeParameterClass.getSimpleName().equals("Video")){

        }

        if(typeParameterClass.getSimpleName().equals("Availablity")){

        }

        return null;
    }



    public void delete(Entity object) {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("DELETE FROM " + typeParameterClass.getSimpleName() + " WHERE id = " + object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Entity object) {
        try{
            placeholder3().executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
