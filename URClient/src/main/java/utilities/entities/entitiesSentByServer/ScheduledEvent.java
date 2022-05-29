package utilities.entities.entitiesSentByServer;

public class ScheduledEvent {
    private String nume;
    private int inceput;
    private int sfarsit;
    private int dimensiune;
    private String grupa;
    private String camera;
    private String tip;



    public ScheduledEvent(String nume, int inceput, int sfarsit, int dimensiune, String grupa, String camera, String tip) {
        this.nume = nume;
        this.inceput = inceput;
        this.sfarsit = sfarsit;
        this.dimensiune = dimensiune;
        this.grupa = grupa;
        this.camera = camera;
        this.tip = tip;
    }
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getInceput() {
        return inceput;
    }

    public void setInceput(int inceput) {
        this.inceput = inceput;
    }

    public int getSfarsit() {
        return sfarsit;
    }

    public void setSfarsit(int sfarsit) {
        this.sfarsit = sfarsit;
    }

    public int getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(int dimensiune) {
        this.dimensiune = dimensiune;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "ScheduledEvent{" +
                "nume='" + nume + '\'' +
                ", inceput=" + inceput +
                ", sfarsit=" + sfarsit +
                ", dimensiune=" + dimensiune +
                ", grupa='" + grupa + '\'' +
                ", camera='" + camera + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }
}
