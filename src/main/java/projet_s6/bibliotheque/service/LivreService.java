package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import projet_s6.bibliotheque.repository.LivreEmpruntRepository;
import projet_s6.bibliotheque.repository.LivreRepository;
import projet_s6.bibliotheque.model.LivreEmprunt;
import projet_s6.bibliotheque.model.VLivreComplet;

import java.util.List;

@Service
public class LivreService {
    
    @Autowired
    private LivreRepository LivreRepository;

    @Autowired
    private LivreEmpruntRepository livreEmpruntRepository;

    public List<VLivreComplet> getAllLivres() {
        return LivreRepository.findAll();
    }

    public List<Integer> getLivreCollection() {
        return LivreRepository.findLivreCollection();
    }

    public List<VLivreComplet> searchLivres(String query) {
        if (query == null || query.isEmpty()) {
            // Si la requête est vide, retourner tous les livres
            return LivreRepository.findAll();
        } else {
            // Sinon, utiliser la recherche avec la requête fournie
            return LivreRepository.searchLivres(query);
        }
    }

    public VLivreComplet findLivreById(Integer id) {
        return LivreRepository.findLivreById(id);
    }

    public VLivreComplet findLivreByCode(String code) {
        return LivreRepository.findLivreByCode(code);
    }

    public Integer findExemplaireRestant(Integer idLivre) {
        return LivreRepository.findExemplaireRestant(idLivre);
    }

    public List<LivreEmprunt> findTop10LivresEmpruntes() {
        return livreEmpruntRepository.findTop10LivresEmpruntes();
    }

    public LivreEmprunt findLivrePlusEmprunte() {
        return livreEmpruntRepository.findLivrePlusEmprunte();
    }

    public List<LivreEmprunt> findLivresRendusByMembreId(Integer id) {
        return livreEmpruntRepository.findLivresRendusByMembreId(id);
    }

    public List<LivreEmprunt> findLivresEnCoursByMembreId(Integer id) {
        return livreEmpruntRepository.findLivresEnCoursByMembreId(id);
    }
    
}
