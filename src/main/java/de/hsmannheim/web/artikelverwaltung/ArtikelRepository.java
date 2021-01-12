package de.hsmannheim.web.artikelverwaltung;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.TreeMap;

@NoArgsConstructor
public class ArtikelRepository {
    private static long counter = 1000000;

    @Getter
    TreeMap<Long, Artikel> artikelMap = new TreeMap<>();


    public void add(Artikel artikel) {
        artikelMap.put(counter++, artikel);
    }

}
