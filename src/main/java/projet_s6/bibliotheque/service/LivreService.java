package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import projet_s6.bibliotheque.repository.LivreRepository;
import projet_s6.bibliotheque.model.Livre;

import java.util.List;

@Service
public class LivreService {
    
    @Autowired
    private LivreRepository LivreRepository;

    public List<Livre> getAllLivres() {
        return LivreRepository.findAll();
    }

    public String test() {
        return "LOML";
    }

    public List<Integer> getLivreCollection() {
        return LivreRepository.findLivreCollection();
    }
}
