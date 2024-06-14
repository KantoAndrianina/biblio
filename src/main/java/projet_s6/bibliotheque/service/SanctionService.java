package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import projet_s6.bibliotheque.model.AutorisationException;
import projet_s6.bibliotheque.model.MembreCategorie;
import projet_s6.bibliotheque.model.VLivreComplet;
import projet_s6.bibliotheque.repository.LivreRepository;
import projet_s6.bibliotheque.repository.MembreCategorieRepository;
import projet_s6.bibliotheque.repository.SanctionRepository;
import projet_s6.bibliotheque.util.DateUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class SanctionService {

    @Autowired
    private SanctionRepository sanctionRepository;

    @Autowired
    private MembreCategorieRepository membreCategorieRepository;

    @Autowired
    private LivreRepository livreCompletRepository;

    @Autowired
    private AutorisationExceptionService autorisationExceptionService;

    public void checkSanction(Integer idMembre) throws Exception {
        if (idMembre == null) {
            throw new Exception("ID du membre non trouvé dans la session");
        }

        Date currentDate = new Date();
        boolean isSanctioned = sanctionRepository.findByIdMembreAndDateFinSanctionAfter(idMembre, currentDate)
                                                  .isPresent();
        if (isSanctioned) {
            throw new Exception("Le membre est actuellement sanctionné");
        }
    }

    public void autoriseAge(Integer idMembre, Integer idLivre) throws Exception {
        MembreCategorie membre = membreCategorieRepository.findById(idMembre).orElse(null);
        if (membre == null) {
            throw new IllegalArgumentException("Membre introuvable avec ID : " + idMembre);
        }

        VLivreComplet livre = livreCompletRepository.findById(idLivre).orElse(null);
        if (livre == null) {
            throw new IllegalArgumentException("Livre introuvable avec ID : " + idLivre);
        }

        LocalDate dateNaissance = DateUtil.convertToLocalDate(membre.getDateNaissance());
        LocalDate today = LocalDate.now();
        int age = Period.between(dateNaissance, today).getYears();

        if (age < livre.getAgeMin()) {
            throw new Exception("Le membre n'est pas autorisé à lire ce livre en raison de son âge.");
        }
    }

    public void autorisationPret(int idMembre, int idLivre, int idTypePret) throws Exception {
        MembreCategorie membre = membreCategorieRepository.findById(idMembre).orElse(null);
        if (membre == null) {
            throw new IllegalArgumentException("Membre introuvable avec ID : " + idMembre);
        }
        int idCatMembre = membre.getIdCatMembre(); 

        List<AutorisationException> exceptions = autorisationExceptionService.getAllAutorisations();

        for (AutorisationException exception : exceptions) {
            if (exception.getIdLivre() == idLivre) {
                if (exception.getIdCatMembre() != idCatMembre && exception.getIdTypePret() == idTypePret) {
                    throw new Exception("Ce livre ne peut pas être emprunté par cette catégorie de membre pour ce type de prêt.");
                }
            }
        }

    }

}