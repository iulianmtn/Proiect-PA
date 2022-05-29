package server.utilities.entities.entitiesSentByServer;

public class FacultyName {
    private String nume;

    public FacultyName(String nume) {
        this.nume = nume;
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
                '}';
    }
}
