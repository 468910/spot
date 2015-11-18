package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import com.google.inject.Inject;
import ica.han.DataSource.IRelationalDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 03/10/15.
 */
public abstract class DAO {

    abstract List GetList();

    public void insert(Entity entity){
        dataSource.insert(entity);
    }

    public Entity GetById(int id){
        ResultSet rs = dataSource.find(new String(Integer.toString(id)));
        try{
            return rowToObject(rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(final Entity object){
        dataSource.update(object);
    }
    public void delete(final Entity object){
        dataSource.delete(object);
    }

    protected abstract Entity rowToObject(ResultSet rs) throws SQLException;

    protected IRelationalDataSource dataSource;

    @Inject
    public DAO(IRelationalDataSource dataSource) {
        this.dataSource = dataSource;

    }

}
