package myblogswing;

public abstract class DBEntity {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DBEntity entity = (DBEntity) o;

        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return (int) (long) id;
    }

    @Override
    public String toString() {
        String[] s = this.getClass().toString().split("\\.");
        String classname = s[s.length - 1];


        return classname + " id:" + id.toString() + ", ";
    }
}
