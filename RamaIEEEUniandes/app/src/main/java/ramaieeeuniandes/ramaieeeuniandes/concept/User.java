package ramaieeeuniandes.ramaieeeuniandes.concept;

import java.util.List;

/**
 * Created by juanm on 26/07/2017.
 */

public class User {

    private Long id;

    private String name;

    private String login;

    private Integer score;

    private List<Event> myEvents;

    private List<Category> myCategories;

    public User(){

    }

    public User(Long id, String name, String login, Integer score) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.score = score;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Event> getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(List<Event> myEvents) {
        this.myEvents = myEvents;
    }

    public List<Category> getMyCategories() {
        return myCategories;
    }

    public void setMyCategories(List<Category> myCategories) {
        this.myCategories = myCategories;
    }
}
