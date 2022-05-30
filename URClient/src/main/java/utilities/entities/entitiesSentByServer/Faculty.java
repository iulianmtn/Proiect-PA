package utilities.entities.entitiesSentByServer;

public class Faculty {
    private String nume;
    private int id;

    public Faculty(String nume, int id) {
        this.nume = nume;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "nume='" + nume + '\'' +
                ", id=" + id +
                '}';
    }
}
