package Domain.DomainObjects;

/**
 * Created by apple on 02/10/15.
 */
public class Availability extends Entity {
    public boolean offlineAvailable;

    public void toggle(){
        offlineAvailable = !offlineAvailable;
    }

    public boolean isOfflineAvailable(){
        return  offlineAvailable;
    }

}
