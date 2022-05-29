package utilities.entities.entitiesSentByServer;

public class FacultyName {
    private String nume;
    private int id;

    public FacultyName(String nume, int id) {
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
        return "FacultyName{" +
                "nume='" + nume + '\'' +
                ", id=" + id +
                '}';
    }
}
