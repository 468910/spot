package han.ica.Service;


import Domain.DomainObjects.Playlist;
import Domain.Service.PlaylistService;
import Domain.Service.RemotePlayListService;
import com.google.inject.Singleton;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 22/10/15.
 */
public class PlaylistServiceRemoteImpl implements RemotePlayListService {

    private int port = 8085;

    @Override
    public void updatePlayList(Playlist playlist)  {

    }

    @Override
    public List<Playlist> getPlaylists(String owner) {

        Registry registry = null;
        try {

            registry = LocateRegistry.getRegistry("localhost", port);
            String[] names = registry.list();
            for(String name : names){
                System.out.println(name);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return  new ArrayList<>();
    }
}
