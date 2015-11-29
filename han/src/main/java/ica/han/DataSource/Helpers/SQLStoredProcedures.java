package ica.han.DataSource.Helpers;

/**
 * Created by apple on 31/10/15.
 */
public class SQLStoredProcedures {

    public static String INSERT_PLAYLIST = "INSERT INTO Playlist(owner, name) VALUES(?, ?)";

    public static String INSERT_TRACK = "INSERT INTO TRACK(performer, title, url, duration) VALUES(?, ?, '?', '?')";

    public static String INSERT_SONG = "INSERT INTO Song(SongPOID, FK_TrackPOID, album) VALUES(?,?)";

    public static String INSERT_VIDEO = "INSERT INTO Video(VideoPOID, FK_TrackPOID, playcount, publicationdate, description) VALUES(?, ?, ?, ?, ?)";

    public static String INSERT_LINK = "INSERT INTO Availability(FK_TrackPOID, FK_PlaylistPOID, onlineAvailability) VALUES(?, ?, ?)";

    public static String UPDATE_Playlist = "UPDATE Playlist SET owner = ?, name = ? WHERE PlaylistPOID = ?";

}
