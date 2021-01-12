package de.hsmannheim.web.artikelverwaltung;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.TreeMap;


public class ArtikelRepository {
    @Getter
    private static long counter = 1000000;

    @Setter
    @Getter
    TreeMap<Long, Artikel> artikelMap = new TreeMap<>();

    public ArtikelRepository(){
        this.add(new Artikel("Test1", 22.0));
        this.add(new Artikel("Test2", 27.0));
        this.add(new Artikel("Test3", 92.0));
    }

    public void add(Artikel artikel) {
        artikelMap.put(counter++, artikel);
    }

}
