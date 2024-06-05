package org.example.maitinimoIstaiga;

public class Uzsakymas {
    private int id;
    private int vartotojoId;
    private int uzsakymas;
    private int patiekaloId;
    private int kiekis;

    public Uzsakymas() {
    }

    public Uzsakymas(int id, int vartotojoId, int uzsakymas, int patiekaloId, int kiekis) {
        this.id = id;
        this.vartotojoId = vartotojoId;
        this.uzsakymas = uzsakymas;
        this.patiekaloId = patiekaloId;
        this.kiekis = kiekis;
    }

    public Uzsakymas(int vartotojoId, int uzsakymas, int patiekaloId, int kiekis) {
        this.vartotojoId = vartotojoId;
        this.uzsakymas = uzsakymas;
        this.patiekaloId = patiekaloId;
        this.kiekis = kiekis;
    }

    public int getId() {
        return id;
    }



    public int getVartotojoId() {
        return vartotojoId;
    }

    public void setVartotojoId(int vartotojoId) {
        this.vartotojoId = vartotojoId;
    }

    public int getUzsakymas() {
        return uzsakymas;
    }

    public void setUzsakymas(int uzsakymas) {
        this.uzsakymas = uzsakymas;
    }

    public int getPatiekaloId() {
        return patiekaloId;
    }

    public void setPatiekaloId(int patiekaloId) {
        this.patiekaloId = patiekaloId;
    }

    public int getKiekis() {
        return kiekis;
    }

    public void setKiekis(int kiekis) {
        this.kiekis = kiekis;
    }

    @Override
    public String toString() {
        return "Uzsakymas{" +
                "id=" + id +
                ", vartotojoId=" + vartotojoId +
                ", uzsakymas=" + uzsakymas +
                ", patiekaloId=" + patiekaloId +
                ", kiekis=" + kiekis +
                '}';
    }
}
