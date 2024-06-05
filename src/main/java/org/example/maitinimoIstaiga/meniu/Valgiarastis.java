package org.example.maitinimoIstaiga.meniu;

public class Valgiarastis {


    //id, pavadinimas, istaigosId

    private int id;
    private String pavadinimas;
    private int istaigosId;

    public Valgiarastis() {
    }

    public Valgiarastis(int id, String pavadinimas, int istaigosId) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.istaigosId = istaigosId;
    }

    public Valgiarastis(String pavadinimas, int istaigosId) {
        this.pavadinimas = pavadinimas;
        this.istaigosId = istaigosId;
    }

    public int getId() {
        return id;
    }



    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getIstaigosId() {
        return istaigosId;
    }

    public void setIstaigosId(int istaigosId) {
        this.istaigosId = istaigosId;
    }

    @Override
    public String toString() {
        return "Valgiarastis{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", istaigosId=" + istaigosId +
                '}';
    }
}
