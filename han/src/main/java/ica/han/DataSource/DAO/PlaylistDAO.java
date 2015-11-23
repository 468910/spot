package ica.han.DataSource.DAO;

import Domain.DomainObjects.Entity;
import Domain.DomainObjects.Playlist;
import Domain.DomainObjects.Track;
import ica.han.DataSource.IRelationalDataSource;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 03/10/15.
 */
public class PlaylistDAO extends DAO {

    public PlaylistDAO(IRelationalDataSource dataSource) {
        super(dataSource);
        System.out.println("Her i am");
    }

    public List GetList() {
        ResultSet rs = dataSource.getList();
        List list = resultSetToList(rs);

        for(Playlist p : (ArrayList<Playlist>)list){
            ResultSet resultset = (dataSource.find("SELECT * FROM Availability INNER JOIN Playlist on PlaylistPOID = FK_PlaylistPOID " +
                    "INNER JOIN Track on TrackPOID = FK_TrackPOID Where owner = " + p.getOwner()));
            try{


            while(resultset.next()) {
                Track track = new Track();
                    System.out.println("Track ADDDEDE");
                    track.setTitle(rs.getString("title"));
                    track.setUrl(rs.getString("url"));
                    track.setPerformer(rs.getString("performer"));
                    track.setDuration(rs.getInt("duration"));

                p.add(track);
            }}catch (Exception e){
                e.printStackTrace();
            }
        }


        return list;

    }

    public List GetListByOwner(String owner){
       ResultSet rs = dataSource.find("SELECT * FROM " + Playlist.class.getSimpleName()
               + " WHERE owner =" + "'" + owner + "'");
        List list = resultSetToList(rs);
        System.out.println("Start");
        for(Playlist p : (ArrayList<Playlist>)list){
            ResultSet resultset = dataSource.find("SELECT * FROM Availability INNER JOIN Playlist on PlaylistPOID = FK_PlaylistPOID " +
                    "INNER JOIN Track on TrackPOID = FK_TrackPOID Where name = '"+ p.getName() + "'");
            try{


                while(resultset.next()) {
                    Track track = new Track();
                    System.out.println("Track ADDDEDE");
                    track.setTitle(resultset.getString("title"));
                    track.setUrl(resultset.getString("url"));
                    track.setPerformer(resultset.getString("performer"));
                    track.setDuration(resultset.getInt("Track.duration"));
                    /*
                    ResultSetMetaData rsmd = resultset.getMetaData();
                    for(int i = 1; i < rsmd.getColumnCount() + 1; i++){
                        System.out.println(rsmd.getColumnName(i));
                    }*/
                    p.add(track);
                }}catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }


    @Override
    protected Entity rowToObject(ResultSet rs) throws SQLException {
        Playlist playList = new Playlist();
        playList.setId(rs.getInt("PlaylistPOID"));
        playList.setName(rs.getString("name"));
        playList.setOwner(rs.getString("owner"));
        return playList;
    }

    protected List resultSetToList(ResultSet rs){
        List list = new ArrayList();
        try {
            while (rs.next()) {
                Playlist playList = (Playlist)rowToObject(rs);
                list.add(playList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


}
