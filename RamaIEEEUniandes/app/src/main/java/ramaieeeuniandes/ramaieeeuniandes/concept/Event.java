package ramaieeeuniandes.ramaieeeuniandes.concept;

import java.sql.Timestamp;

/**
 * Created by juanm on 26/07/2017.
 */

public class Event {

    private Long id;

    private String name;

    private Timestamp date;

    private String place;

    private Integer capacity;

    private String description;

    private int image;

    public Event() {
    }

    public Event(Long id, String name, Timestamp date, String place, Integer capacity, String description,int image) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.capacity = capacity;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}