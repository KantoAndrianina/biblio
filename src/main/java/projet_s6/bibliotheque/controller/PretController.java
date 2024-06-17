package projet_s6.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.sql.*;

import projet_s6.bibliotheque.model.AutorisationException;
import projet_s6.bibliotheque.model.Membre;
import projet_s6.bibliotheque.model.MembreCategorie;
import projet_s6.bibliotheque.model.Pret;
import projet_s6.bibliotheque.model.VAutorisationDetail;
import projet_s6.bibliotheque.model.VLivreComplet;
import projet_s6.bibliotheque.model.VPretDetail;
import projet_s6.bibliotheque.service.AutorisationDetailService;
import projet_s6.bibliotheque.service.AutorisationExceptionService;
import projet_s6.bibliotheque.service.LivreService;
import projet_s6.bibliotheque.service.MembreCategorieService;
import projet_s6.bibliotheque.service.MembreService;
import projet_s6.bibliotheque.service.PretDetailService;
import projet_s6.bibliotheque.service.PretService;
import projet_s6.bibliotheque.service.SanctionService;
import projet_s6.bibliotheque.util.DateUtil;

import org.springframework.ui.Model;

@Controller
public class PretController {

    @Autowired
    private MembreCategorieService membreCategorieService;

    @Autowired
    private LivreService livreService;

    @Autowired
    private SanctionService sanctionService;

    @Autowired
    private PretService pretService;

    @Autowired
    private PretDetailService pretDetailService;

    @Autowired
    private AutorisationDetailService autorisationDetailService;

    // @GetMapping("/pret")
    // public String showPretPage() {
    //     return "pret";
    // }

    @GetMapping("/pret/recherche-membre")
    public String searchMembre(@RequestParam(required = false) String nom, Model model) {
        List<MembreCategorie> membres;
        if (nom != null && !nom.isEmpty()) {
            membres = membreCategorieService.searchMembresByNom(nom);
        } else {
            membres = membreCategorieService.getAllMembresCategories();
        }
        model.addAttribute("membres", membres);
        return "admin/pret";
    }

    @GetMapping("/pret/recherche-livre/{id}")
    public String rechercheLivre(@PathVariable("id") Integer idMembre, Model model,  HttpSession session) {
        session.setAttribute("pretIdMembre", idMembre);
        return "admin/recherche_livre"; 
    }

    @GetMapping("/pret/recherche-livre-pret")
    public String rechercheLivrePret(@RequestParam String code, Model model) {
        VLivreComplet livre = livreService.findLivreByCode(code);
        model.addAttribute("livre", livre);
        return "admin/resultat_livre"; 
    }

    @GetMapping("/pret/selectionner-livre/{id}")
    public String selectionLivrePret(@PathVariable("id") Integer id, Model model, HttpSession session) {
        try {
            VLivreComplet livre = livreService.findLivreById(id);
            model.addAttribute("livre", livre);
            
            List<VAutorisationDetail> autorisations = autorisationDetailService.findAutorisationDetailByLivreId(id);
            model.addAttribute("autorisations", autorisations);

            Integer pretIdMembre = (Integer) session.getAttribute("pretIdMembre");
            if (pretIdMembre == null) {
                throw new Exception("Aucun ID de membre trouvé dans la session");
            }

            MembreCategorie membre = membreCategorieService.findById(pretIdMembre);

            return "admin/selection_livre"; 

        } catch (Exception e) {
            List<MembreCategorie> membres = membreCategorieService.getAllMembresCategories();
            model.addAttribute("membres", membres);
            return "redirect:pret/recherche-membre";  
        }
        

    }

    @PostMapping("/pret/valider-selection")
    public String validerSelection(@RequestParam("idLivre") Integer idLivre,
                                   @RequestParam("typePret") Integer typePret,
                                   HttpSession session, Model model) {
        try {
            Integer pretIdMembre = (Integer) session.getAttribute("pretIdMembre");
            if (pretIdMembre == null) {
                throw new Exception("Aucun ID de membre trouvé dans la session");
            }

            sanctionService.checkSanction(pretIdMembre);
            sanctionService.autoriseAge(pretIdMembre, idLivre);
            sanctionService.autorisationPret(pretIdMembre, idLivre,typePret);

            MembreCategorie membre = membreCategorieService.findById(pretIdMembre);
            int nbJourPret = membre.getNbJourPret();
            

            LocalDate localDateDebutPret = LocalDate.now();
            LocalDate localDateFinPret;

            if(typePret == 1)
            {
                localDateFinPret = localDateDebutPret;
            }else 
            {
                localDateFinPret = localDateDebutPret.plusDays(nbJourPret);
            }

            Date dateDebutPret = java.sql.Date.valueOf(localDateDebutPret);
            Date dateFinPret = java.sql.Date.valueOf(localDateFinPret);

            Integer idExemplaire = livreService.findExemplaireRestant(idLivre);

            Pret pret = pretService.creerPret(dateDebutPret, dateFinPret, typePret, idExemplaire, pretIdMembre);
            
            model.addAttribute("idLivre", idLivre);
            model.addAttribute("typePret", typePret);
            model.addAttribute("pretIdMembre", pretIdMembre);
            model.addAttribute("idExemplaire", idExemplaire);
            model.addAttribute("dateDebutPret", dateDebutPret);
            model.addAttribute("dateFinPret", dateFinPret);

            return "redirect:/admin/prets-en-cours";

        } catch (Exception e) {
            VLivreComplet livre = livreService.findLivreById(idLivre);
            model.addAttribute("livre", livre);
            model.addAttribute("errorMessage", e.getMessage());
            List<VAutorisationDetail> autorisations = autorisationDetailService.findAutorisationDetailByLivreId(idLivre);
            model.addAttribute("autorisations", autorisations);
            return "admin/selection_livre";  
        }
    }

    @GetMapping("/admin/prets-en-cours")
    public String getPretsEnCours(Model model) {
        List<VPretDetail> pretsEnCours = pretDetailService.findPretsEnCours();
        model.addAttribute("prets", pretsEnCours);
        return "admin/prets_en_cours"; // Le nom de la vue
    }

    @PostMapping("/rendre-pret")
    public String rendrePret(@RequestParam("idPret") Integer idPret) {
        pretService.rendrePret(idPret);
        return "redirect:/admin/prets-en-cours";
    }

    @GetMapping("/admin/historique")
    public String getHistorique(Model model) {
        List<VPretDetail> pretsEnCours = pretDetailService.findPretsRendus();
        model.addAttribute("prets", pretsEnCours);
        return "admin/historique"; // Le nom de la vue
    }

}


