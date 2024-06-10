package projet_s6.bibliotheque.controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import projet_s6.bibliotheque.service.LivreService;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping("/livres")
    public String listLivres(Model model) {
        model.addAttribute("livres", livreService.getAllLivres());
        return "anonyme/livres";
    }

}
