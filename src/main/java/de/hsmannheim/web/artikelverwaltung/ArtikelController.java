package de.hsmannheim.web.artikelverwaltung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtikelController {
    ArtikelRepository artikelRepository = new ArtikelRepository();


    @GetMapping("/test")
    public String show(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", artikelRepository.getArtikelMap());
        return "index";
    }



    @GetMapping("/create")
    public String add(@RequestParam(name = "name", required = false, defaultValue = "false") String name,
                      @RequestParam(name = "price", required = false) Double price, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("price", price);

        if (!name.equals("false")) {
            artikelRepository.add(new Artikel(name, price));
            return "redirect:/show?id=" + (artikelRepository.getCounter() - 1);
        }

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


        return "redirect:/show?id=" + id;
    }


    @GetMapping("/destroy")
    public String destroy(@RequestParam(name = "id") Long id, Model model) {
        artikelRepository.getArtikelMap().remove(id);

        return "redirect:/";
    }


}
