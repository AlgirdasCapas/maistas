package org.example.maitinimoIstaiga.meniu.patiekalas;

public class Patiekalas {
    private int id;
    private int valgiarascioId;
    private String pavadinimas;
    private String aprasas;
    private double kaina;

    public Patiekalas() {
    }

    public Patiekalas(int id, int valgiarascioId, String pavadinimas, String aprasas, double kaina) {
        this.id = id;
        this.valgiarascioId = valgiarascioId;
        this.pavadinimas = pavadinimas;
        this.aprasas = aprasas;
        this.kaina = kaina;
    }

    public Patiekalas(int valgiarascioId, String pavadinimas, String aprasas, double kaina) {
        this.valgiarascioId = valgiarascioId;
        this.pavadinimas = pavadinimas;
        this.aprasas = aprasas;
        this.kaina = kaina;
    }

    public int getId() {
        return id;
    }



    public int getValgiarascioId() {
        return valgiarascioId;
    }

    public void setValgiarascioId(int valgiarascioId) {
        this.valgiarascioId = valgiarascioId;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAprasas() {
        return aprasas;
    }

    public void setAprasas(String aprasas) {
        this.aprasas = aprasas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    @Override
    public String toString() {
        return "Patiekalas{" +
                "id=" + id +
                ", valgiarascioId=" + valgiarascioId +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", aprasas='" + aprasas + '\'' +
                ", kaina=" + kaina +
                '}';
    }
}
