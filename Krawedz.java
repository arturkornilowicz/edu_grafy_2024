package grafy;

public class Krawedz {

    Wierzcholek skad, dokad;
    int waga;

    public Krawedz(Wierzcholek skad, Wierzcholek dokad, int waga) {
        this.skad = skad;
        this.dokad = dokad;
        this.waga = waga;
    }

    @Override
    public String toString() {
        return dokad.nazwa + ", " + waga;
    }

    void relaksujKrawedz() {
        if (skad.koszt + waga < dokad.koszt) {
            dokad.koszt = skad.koszt + waga;
            dokad.poprzednik = skad;
        }
    }
}
