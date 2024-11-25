package grafy;

import java.util.*;

public class Wierzcholek {

    String nazwa;

    boolean obsluzony;
    int koszt = Integer.MAX_VALUE;
    Wierzcholek poprzednik = this;


    // Lista krawędzi wychodzących z wierzchołka
    List<Krawedz> krawedzie = new ArrayList<>();

    public Wierzcholek(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        String wynik = nazwa + " [" + koszt + " " + poprzednik.nazwa + "] " + " -> ";
        for (Krawedz krawedz: krawedzie) {
            wynik += krawedz + "; ";
        }
        return wynik;
    }

    void dodajKrawedz(Krawedz krawedz) {
        this.krawedzie.add(krawedz);
    }

    void dodajKrawedz(Wierzcholek dokad, int waga) {
        dodajKrawedz(new Krawedz(this,dokad,waga));
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Wierzcholek))
            return false;
        return this.nazwa.equals(((Wierzcholek)obj).nazwa);
    }

    void relaksujKrawedzie() {
        for (Krawedz krawedz: krawedzie) {
            krawedz.relaksujKrawedz();
        }
    }
}
