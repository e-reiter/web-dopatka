package de.hsmannheim.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloWeltController {
    private static final String vorlage = "Hallo ";
    private long counter;

    @GetMapping("/hallo")
    public HalloWelt hallo(@RequestParam(value = "name", defaultValue = "Welt") String name){
        return new HalloWelt(counter++, vorlage+name);
    }


}
