package mn.tuugii.eLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/elibrary", "/elibrary/home"})
    public String home(){
        return "home/index";
    }

}
