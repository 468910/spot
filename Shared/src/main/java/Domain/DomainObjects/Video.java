package Domain.DomainObjects;

import java.util.Calendar;

/**
 * Created by apple on 02/10/15.
 */
public class Video extends Track  {
    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int playCount;
    public Calendar publicationDate;
    public String description;


}
