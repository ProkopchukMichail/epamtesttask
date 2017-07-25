package testtask.model;

/**
 * Created by comp on 25.07.2017.
 */
public class HasId {
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

    public boolean isNew(){
        return  id==null;
    }
}
