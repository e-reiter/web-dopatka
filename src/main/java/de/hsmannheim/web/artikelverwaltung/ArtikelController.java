package de.hsmannheim.web.artikelverwaltung;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtikelController {
private long counter=100000;


    @GetMapping("/neu")
    public Artikel anlegen(@RequestParam(value = "name", defaultValue = "leer") String name,
                           @RequestParam(value ="price", defaultValue = "0.00") double price){
        return new Artikel(counter++,name,price);
    }
}
