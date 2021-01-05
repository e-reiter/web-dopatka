package de.hsmannheim.web.artikelverwaltung;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Artikel {
    @Getter
    @Setter
    private final long artikelnr;


    @Getter
    @Setter
    private final String name;

    @Getter
    @Setter
    private double price;


}
