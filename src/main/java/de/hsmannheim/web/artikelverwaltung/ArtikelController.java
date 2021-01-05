package de.hsmannheim.web.artikelverwaltung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

@Controller
public class ArtikelController {
    private long counter = 100000;
    private Model model;
    TreeMap<Long, Artikel> artikelList = new TreeMap<>();
//index(Alle artikel), Show(ein artikel), Store(response für speichern), Edit(request für ARtikel ändern),
// Destroy(artikel löschen), Add(hinzufügen)

    @GetMapping("/test")
    public String show(@RequestParam(name="name") String name, Model model) {
    model.addAttribute("name", artikelList.get(counter-1).toString());
    return "test";
    }


    @GetMapping("/index")
    public String index(){

        return "index";
    }


    @GetMapping("/show")
    public String show(){

        return "show";
    }


    @GetMapping("/store")
    public String store(){

        return "store";
    }


    @GetMapping("/destroy")
    public String edit(){

        return "destroy";
    }

    @GetMapping("/add")
    public String add(){

        return "add";
    }





}
