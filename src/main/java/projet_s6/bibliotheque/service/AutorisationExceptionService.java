package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.AutorisationException;
import projet_s6.bibliotheque.model.VLivreComplet;
import projet_s6.bibliotheque.repository.AutorisationExceptionRepository;
import projet_s6.bibliotheque.repository.LivreRepository;

import java.util.List;

@Service
public class AutorisationExceptionService {

    @Autowired
    private AutorisationExceptionRepository autorisationExceptionRepository;

    public List<AutorisationException> getAllAutorisations() {
        return autorisationExceptionRepository.findAll();
    }

    public List<AutorisationException> findAutorisationsByLivreId(Integer idLivre) {
        return autorisationExceptionRepository.findByIdLivre(idLivre);
    }
}
