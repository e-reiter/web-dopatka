package de.hsmannheim.web.artikelverwaltung;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

@Controller
public class ArtikelController {
    private long counter = 100000;
    private Model model;
   // TreeMap<Long, Artikel> artikelList = new TreeMap<>();
    ArrayList<Artikel> artikelList = new ArrayList<>();


    @GetMapping("/test")
    public String show(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }


    @GetMapping("/index")
    public String index() {

        return "index";
    }

    @GetMapping("/create")
    public String add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "price") Double price, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("price", price);
      //Geht nicht. Nullpointerexception wenn man versucht auf die liste zuzugreifen. Sowohl mit TreeMap als auch mit Arraylist...
        //i weiß nemmer woida :(
        //  artikelList.add(new Artikel(name,price));

        return "create";
    }

    @GetMapping("/store")
    public String store() {

        return "show";
    }

    @GetMapping("/show")
    public String show() {

        return "show";
    }

    @GetMapping("/edit")
    public String edit() {

        return "edit";
    }

    @GetMapping("/update")
    public String update() {

        return "show";
    }


    @GetMapping("/destroy")
    public String destroy() {

        return "index";
    }


}
