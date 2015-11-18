package ica.han.Domain.POJO;

import Domain.DomainObjects.Playlist;
import Domain.Service.RemotePlayListService;
import ica.han.DataSource.DAO.DAOManager;
import ica.han.DataSource.DAO.PlaylistDAO;


import java.util.List;

/**
 * Created by apple on 07/10/15.
 */
public class RemotePlaylistServiceImpl implements RemotePlayListService {

    private PlaylistDAO playlistDAO = (PlaylistDAO) new DAOManager().getDAO(DAOManager.Table.Playlist);

    public RemotePlaylistServiceImpl(){

    }

    public void updatePlayList(Playlist playlist)  {
        playlistDAO.update(playlist);
    }

    public List<Playlist> getPlaylists(String owner) {
        return playlistDAO.GetList();
    }
}
