package myblogswing;

public class Category extends DBEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() +
                "name='" + name + '\'';
    }

}
