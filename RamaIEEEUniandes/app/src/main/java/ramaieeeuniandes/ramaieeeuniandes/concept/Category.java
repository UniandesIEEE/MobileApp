package ramaieeeuniandes.ramaieeeuniandes.concept;

import java.io.Serializable;

/**
 * Created by juanm on 26/07/2017.
 */

public class Category implements Serializable{

    private Long id;

    private String name;

    public Category() {

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
