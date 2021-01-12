package de.hsmannheim.web.artikelverwaltung;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Artikel {

    @Getter
    @Setter
    private  String name;



    @Getter
    @Setter
    private double price;


}
