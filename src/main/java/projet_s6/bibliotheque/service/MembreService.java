package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.Membre;
import projet_s6.bibliotheque.model.VLivreComplet;
import projet_s6.bibliotheque.repository.LivreRepository;
import projet_s6.bibliotheque.repository.MembreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MembreService {

    @Autowired
    private MembreRepository membreRepository;

    public List<Membre> getAllMembres() {
        return membreRepository.findAll();
    }

    public Membre findByNomMembre(String nomMembre) {
        return membreRepository.findByNomMembreIgnoreCase(nomMembre);
    }

    public Optional<Membre> findById(Integer idMembre) {
        return membreRepository.findById(idMembre);
    }

}
