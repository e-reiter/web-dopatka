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
import java.util.Map;
import java.util.TreeMap;

@Controller
public class ArtikelController {
    private Model model;
    ArtikelRepository artikelRepository = new ArtikelRepository();


    @GetMapping("/test")
    public String show(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }

    //TODO: Umgehen das bei refresh artikel dupliziert werden
    @GetMapping("/")
    public String index(Model model) {

        artikelRepository.add(new Artikel("Test1", 22.0));
        artikelRepository.add(new Artikel("Test2", 27.0));
        artikelRepository.add(new Artikel("Test3", 92.0));


        model.addAttribute("articles", artikelRepository.getArtikelMap());
        return "index";
    }

    @GetMapping("/index")
    public String home() {

        return "index";
    }


    @GetMapping("/create")
    public String add(@RequestParam(name = "name", required = false, defaultValue = "false") String name,
                      @RequestParam(name = "price", required = false) Double price, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("price", price);

        if (!name.equals("false"))
            artikelRepository.add(new Artikel(name, price));


        return "create";
    }


    @GetMapping("/show")
    public String showAr(@RequestParam(name = "id", required = false, defaultValue = "0") Long id,
                         Model model) {
        if (artikelRepository.getArtikelMap().containsKey(id)) {
            model.addAttribute("articlenumber", id);
            model.addAttribute("name", artikelRepository.getArtikelMap().get(id).getName());
            model.addAttribute("price", artikelRepository.getArtikelMap().get(id).getPrice());
        }
        return "show";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        if (artikelRepository.getArtikelMap().containsKey(id)) {
            model.addAttribute("articlenumber", id);
            model.addAttribute("name", artikelRepository.getArtikelMap().get(id).getName());
            model.addAttribute("price", artikelRepository.getArtikelMap().get(id).getPrice());
        }

        return "edit";

    }







    @GetMapping("/update")
    public String update(@RequestParam(name = "id") Long id,
    @RequestParam(name = "name", required = false, defaultValue = "false") String name,
    @RequestParam(name = "price", required = false, defaultValue = "-1") Double price, Model model) {


        //show article
        if (artikelRepository.getArtikelMap().containsKey(id)) {
            model.addAttribute("articlenumber", id);
            model.addAttribute("name", artikelRepository.getArtikelMap().get(id).getName());
            model.addAttribute("price", artikelRepository.getArtikelMap().get(id).getPrice());
        }


        if (!name.equals("false")) {
            artikelRepository.getArtikelMap().get(id).setName(name);

        }

        if (price != -1) {
            artikelRepository.getArtikelMap().get(id).setPrice(price);
        }


        return "redirect:/show?id="+id;
    }




    @GetMapping("/destroy")
    public String destroy() {

        return "index";
    }


}
