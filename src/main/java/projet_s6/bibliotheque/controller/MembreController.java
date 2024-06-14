package projet_s6.bibliotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import projet_s6.bibliotheque.model.LivreEmprunt;
import projet_s6.bibliotheque.model.Membre;
import projet_s6.bibliotheque.service.LivreService;
import projet_s6.bibliotheque.service.MembreService;

@Controller
public class MembreController {
    
    @Autowired
    private MembreService membreService;

    @Autowired
    private LivreService livreService;

    @GetMapping("/membre/login")
    public String loginForm() {
        return "membre/login";
    }

    @PostMapping("/membre/login-post")
    public String login(String nomMembre, HttpSession session, Model model) {
        Membre membre = membreService.findByNomMembre(nomMembre);
        if (membre != null) {
            session.setAttribute("membreId", membre.getIdMembre());
            List<LivreEmprunt> livresEmpruntes = livreService.findLivresRendusByMembreId(membre.getIdMembre());
            List<LivreEmprunt> livresEnCours = livreService.findLivresEnCoursByMembreId(membre.getIdMembre());

            model.addAttribute("livresEmpruntes",livresEmpruntes);
            model.addAttribute("livresEnCours",livresEnCours);

            return "membre/livre_emprunt";
        } else {
            model.addAttribute("error", "Nom de membre incorrect");
            return "membre/login";
        }
    }

    @GetMapping("/membre/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("membreId");
        return "redirect:/membre/login";
    }

}
