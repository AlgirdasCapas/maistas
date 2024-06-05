package org.example.maitinimoIstaiga;

public class MaitinimoIstaiga {
    private int id;
    private String pavadinimas;
    private String kodas;
    private String adresas;

    public MaitinimoIstaiga(){}

    public MaitinimoIstaiga (int id, String pavadinimas, String kodas, String adresas)
    {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kodas = kodas;
        this.adresas = adresas;
    }
    public MaitinimoIstaiga (String pavadinimas, String kodas, String adresas) {
        this.pavadinimas = pavadinimas;
        this.kodas = kodas;
        this.adresas = adresas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getKodas() {
        return kodas;
    }

    public void setKodas(String kodas) {
        this.kodas = kodas;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MaitinimoIstaiga{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kodas='" + kodas + '\'' +
                ", adresas='" + adresas + '\'' +
                '}';
    }
}
