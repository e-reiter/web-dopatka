package de.hsmannheim.web.artikelverwaltung;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

@RestController
public class ArtikelController {
private long counter=100000;
TreeMap<Long, Artikel> artikelList = new TreeMap<>();



    @GetMapping("/neu")
    public Artikel anlegen(@RequestParam(value = "name", defaultValue = "leer") String name,
                           @RequestParam(value ="price", defaultValue = "0.00") double price){
        artikelList.put(counter++, new Artikel(name,price));
        return artikelList.get(counter-1);
    }

    @GetMapping("/anzeigen")
    public TreeMap<Long, Artikel> anzeigen(){
        return artikelList;

    }

    @GetMapping("/loeschen")
    public void loeschen(@RequestParam(value="artikelnr") long artikelnr){

    }

}
