package grafy;

import java.util.*;

public class Graf {

    String nazwa;
    List<Wierzcholek> wierzcholki = new ArrayList<>();

    public Graf(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        String wynik = nazwa + "\n";
        for (Wierzcholek wierzcholek: wierzcholki) {
            wynik += wierzcholek + "\n";
        }
        return wynik;
    }

    Wierzcholek dodajWierzcholek(Wierzcholek wierzcholek) {
        if (wierzcholki.indexOf(wierzcholek) == -1)
            this.wierzcholki.add(wierzcholek);
        return wierzcholek;
    }

    Wierzcholek dodajWierzcholek(String nazwa) {
        return dodajWierzcholek(new Wierzcholek(nazwa));
    }

    void dodajKrawedz(Wierzcholek skad, Wierzcholek dokad, int waga) {
        skad.dodajKrawedz(new Krawedz(skad,dokad,waga));
    }

    Wierzcholek znajdzWierzcholek(String nazwa) {
        int pozycja = wierzcholki.indexOf(new Wierzcholek(nazwa));
        if (pozycja >= 0)
            return wierzcholki.get(pozycja);
        return null;
    }

    void dodajKrawedz(String skad, String dokad, int waga) {
        Wierzcholek w1 = znajdzWierzcholek(skad);
        Wierzcholek w2 = znajdzWierzcholek(dokad);
        if (w1 == null) {
            w1 = dodajWierzcholek(skad);
        }
        if (w2 == null) {
            w2 = dodajWierzcholek(dokad);
        }
        dodajKrawedz(w1, w2, waga);
    }

    // 1. Wypisać wierzcholek, z którego wydzodzi najwięcej krawędzi
    // 2. Wypisać wierzchołek, do którego wchodzi najwięcej krawędzi

    // zwraca wierzchołek o najniższym koszcie spośród nieobsłuzonych
    Wierzcholek min() {
        Wierzcholek wynik = null;
        int min = Integer.MAX_VALUE;
        for (Wierzcholek w: wierzcholki) {
            if (!w.obsluzony) {
                if (w.koszt < min) {
                    wynik = w;
                    min = w.koszt;
                }
            }
        }
        return wynik;
    }

    void Dijkstra(Wierzcholek skad) {
        for (Wierzcholek wierzcholek: wierzcholki) {
            wierzcholek.koszt = Integer.MAX_VALUE;
            wierzcholek.obsluzony = false;
        }
        skad.koszt = 0;
        Wierzcholek minimalny = skad;
        while (minimalny != null) {
            minimalny.relaksujKrawedzie();
            minimalny.obsluzony = true;
            minimalny = min();
        }
    }

    void Dijkstra(String skad) {
        Dijkstra(znajdzWierzcholek(skad));
    }

    List<Wierzcholek> znajdzPolaczenie(Wierzcholek skad, Wierzcholek dokad) {
        List<Wierzcholek> wynik = new ArrayList<>();
        Dijkstra(skad);
        Wierzcholek w = dokad;
        while (!w.equals(skad)) {
            wynik.add(w);
            w = w.poprzednik;
        }
        wynik.add(skad);
        Collections.reverse(wynik);
        return wynik;
    }

    List<Wierzcholek> znajdzPolaczenie(String skad, String dokad) {
        return znajdzPolaczenie(znajdzWierzcholek(skad),znajdzWierzcholek(dokad));
    }
}
