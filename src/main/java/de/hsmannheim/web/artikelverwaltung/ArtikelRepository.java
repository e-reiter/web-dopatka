package de.hsmannheim.web.artikelverwaltung;
import lombok.Getter;
import lombok.Setter;
import java.util.TreeMap;


public class ArtikelRepository {
    @Getter
    private static long counter = 1000000;

    @Setter
    @Getter
    TreeMap<Long, Artikel> artikelMap = new TreeMap<>();

    public ArtikelRepository(){
        this.add(new Artikel("Maus", 22.0));
        this.add(new Artikel("Tastatur", 27.0));
        this.add(new Artikel("Heizung", 92.99));
    }

    public void add(Artikel artikel) {
        artikelMap.put(counter++, artikel);
    }

}
