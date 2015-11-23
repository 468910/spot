package ica.han.DataSource.Helpers;

/**
 * Created by apple on 07/10/15.
 */
public class SQLTableStatements {
    public static String CREATE_TABLE_PLAYLIST = "CREATE TABLE Playlist " +
                                                 "(PlaylistPOID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY, " +
                                                 " owner VARCHAR(255) not NULL," +
                                                 " name VARCHAR(255) not NULL UNIQUE)";



    public static String CREATE_TABLE_TRACK = "CREATE TABLE Track " +
                                                "(TrackPOID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY, " +
                                                " performer VARCHAR(255) not NULL, " +
                                                " title VARCHAR(255) not NULL, " +
                                                " url VARCHAR(255) not NULL, " +
                                                " duration INTEGER not NULL)";



    public static String CREATE_TABLE_VIDEO = "CREATE TABLE Video " +
                                              " (VideoPOID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY," +
                                              " FK_TrackPOID INTEGER not NULL, " +
                                              " playcount INTEGER not NULL, " +
                                              " publicationdate TIMESTAMP not NULL, " +
                                              " description VARCHAR(255) not NULL, " +
                                              " FOREIGN KEY (FK_TrackPOID) REFERENCES Track(TrackPOID))";

    public static String CREATE_TABLE_SONG = "CREATE TABLE Song " +
                                             " (SongPOID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY, " +
                                             " FK_TrackPOID INTEGER not NULL," +
                                             " album VARCHAR(255), " +
                                             " FOREIGN KEY (FK_TrackPOID) REFERENCES Track(TrackPOID))";


    public static String CREATE_TABLE_AVAILABILITY = "CREATE TABLE Availability " +
                                                     " (AvailabilityPOID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY, " +
                                                     " FK_TrackPOID INTEGER not NULL, " +
                                                     " FK_PlaylistPOID INTEGER not null, " +
                                                     " onlineAvailability BOOLEAN not NULL," +
                                                     " FOREIGN KEY (FK_TrackPOID) REFERENCES Track(TrackPOID), " +
                                                     " FOREIGN KEY (FK_PlaylistPOID) REFERENCES Playlist(PlaylistPOID))";


}
