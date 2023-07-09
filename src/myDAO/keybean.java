package myDAO;

public class keybean {
    int id;
    String key1;
    String session1;

    public keybean(int id, String key1, String session1) {
        this.id = id;
        this.key1 = key1;
        this.session1 = session1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getSession1() {
        return session1;
    }

    public void setSession1(String session1) {
        this.session1 = session1;
    }

    public keybean() {
    }
}
