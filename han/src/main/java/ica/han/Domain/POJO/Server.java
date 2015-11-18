package ica.han.Domain.POJO;

import Domain.Service.RemotePlayListService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by apple on 22/10/15.
 */
// TODO singleton
@Singleton
public class Server {

    @Inject
    public RemotePlayListService remotePlayListService;

    public static int PORT = 8085;


    public  void initService(){
        try{
            RemotePlayListService stub = (RemotePlaylistServiceImpl) UnicastRemoteObject.exportObject(remotePlayListService, 0);
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.bind(remotePlayListService.getClass().getName(), stub);
            System.out.println("Remote service is bound!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
