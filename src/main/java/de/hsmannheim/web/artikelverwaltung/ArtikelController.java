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
//index(Alle artikel), Show(ein artikel), Store(response für speichern), Edit(request für Artikel ändern),
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

    @GetMapping("/create")
    public String add(){

        return "create";
    }

    @GetMapping("/store")
    public String store(){

        return "show";
    }

    @GetMapping("/show")
    public String show(){

        return "show";
    }

    @GetMapping("/edit")
    public String edit(){

        return "edit";
    }

    @GetMapping("/update")
    public String update(){

        return "show";
    }


    @GetMapping("/destroy")
    public String destroy(){

        return "index";
    }





}
