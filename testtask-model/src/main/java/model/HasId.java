package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by comp on 25.07.2017.
 */
public class HasId  implements Serializable{
    private Integer id;

    public HasId(Integer id) {
        this.id = id;
    }

    public HasId() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isNew(){
        return  id==null;
    }
}
