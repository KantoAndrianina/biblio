package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.Membre;
import projet_s6.bibliotheque.model.VLivreComplet;
import projet_s6.bibliotheque.repository.LivreRepository;
import projet_s6.bibliotheque.repository.MembreRepository;

import java.util.List;

@Service
public class MembreService {

    @Autowired
    private MembreRepository membreRepository;

    public List<Membre> getAllMembres() {
        return membreRepository.findAll();
    }
}
