package grafy;

public class Grafy {

    public static void main(String[] args) {

        Graf g = new Graf("PKP Polska");

//        Wierzcholek bialystok = new Wierzcholek("Białystok");
//        Wierzcholek warszawa = new Wierzcholek("Warszawa");
//        Wierzcholek krakow = new Wierzcholek("Kraków");
//
//        g.dodajWierzcholek(bialystok);
//        g.dodajWierzcholek(warszawa);
//        g.dodajWierzcholek(krakow);
//
//        g.dodajWierzcholek("Sopot");
//        g.dodajWierzcholek("Zakopane");
//        g.dodajWierzcholek("Zakopane");
//        g.dodajWierzcholek("Zakopane");
//        g.dodajWierzcholek("Zakopane");
//        g.dodajWierzcholek("Zakopane");
//
//        g.dodajKrawedz(warszawa,krakow,100);
//
//        bialystok.dodajKrawedz(krakow,300);

        g.dodajKrawedz("Białystok", "Zakopane", 16201);
        g.dodajKrawedz("Białystok", "Poznań", 500);
        g.dodajKrawedz("Poznań", "Zakopane", 1550);
        g.dodajKrawedz("Poznań", "Jelenia Góra", 260);
        g.dodajKrawedz("Jelenia Góra","Zakopane",460);

        System.out.println(g);

//        g.Dijkstra("Poznań");
//        g.Dijkstra("Białystok");
        g.Dijkstra("Zakopane");
        g.Dijkstra("Jelenia Góra");
        System.out.println(g);

        String skad = "Białystok";
        String dokad = "Zakopane";
        System.out.println("Połączenie " + skad + " -> " + dokad);
        for (Wierzcholek wierzcholek: g.znajdzPolaczenie(skad,dokad)) {
            System.out.println(wierzcholek.nazwa);
        }
    }
}
