package projet_s6.bibliotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import projet_s6.bibliotheque.model.VLivreComplet;
import projet_s6.bibliotheque.service.LivreService;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    // @GetMapping("/livres")
    // public String showLivresPage(Model model) {
    //     List<VLivreComplet> allLivres = livreService.getAllLivres();
    //     model.addAttribute("livres", allLivres);
    //     return "anonyme/livres";
    // }

    @GetMapping("/livres/recherche")
    public String searchLivres(@RequestParam(required = false) String query, Model model) {
        List<VLivreComplet> livres = livreService.searchLivres(query);
        model.addAttribute("livres", livres);
        return "anonyme/livres"; 
    }

    @GetMapping("/livres/{id}")
    public String detailLivre(@PathVariable Integer id, Model model) {
        VLivreComplet livre = livreService.findLivreById(id);
        model.addAttribute("livre", livre);
        return "anonyme/livre_detail";
    }

}
