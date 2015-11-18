package Domain.Service;


import Domain.DomainObjects.Playlist;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by apple on 22/10/15.
 */
public interface RemotePlayListService extends Remote  {

    public void updatePlayList(Playlist playlist) throws RemoteException;

    public List<Playlist> getPlaylists(String owner) throws RemoteException;
}
