package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import projet_s6.bibliotheque.repository.LivreRepository;
import projet_s6.bibliotheque.model.Livre;
import projet_s6.bibliotheque.model.VLivreComplet;

import java.util.List;

@Service
public class LivreService {
    
    @Autowired
    private LivreRepository LivreRepository;

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
    
}
