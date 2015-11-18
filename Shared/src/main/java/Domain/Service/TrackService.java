package Domain.Service;

import Domain.DomainObjects.Track;

import java.util.List;

/**
 * Created by apple on 29/10/15.
 */
public interface TrackService {

    List<Track> getTracks(String title);
}
