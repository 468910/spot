package Domain.DomainObjects;



/**
 * Created by apple on 02/10/15.
 */



public class Track extends Entity {
    private String performer;
    private String title;
    private String url;
    private long duration;
    public Class objectType;

    public Track(String performer, String title, String url, long duration) {
        this.performer = performer;
        this.title = title;
        this.url = url;
        this.duration = duration;
    }

    public Track(){

    }


    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    private Availability availability;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }


}
