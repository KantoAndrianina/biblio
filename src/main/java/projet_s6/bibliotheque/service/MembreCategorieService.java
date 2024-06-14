package projet_s6.bibliotheque.service;


import projet_s6.bibliotheque.model.Membre;
import projet_s6.bibliotheque.model.MembreCategorie;
import projet_s6.bibliotheque.repository.LivreRepository;
import projet_s6.bibliotheque.repository.MembreCategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MembreCategorieService {
    @Autowired
    private MembreCategorieRepository membreCategorieRepository;

    public List<MembreCategorie> searchMembresByNom(String nom) {
        return membreCategorieRepository.findByNomContainingIgnoreCase(nom);
    }

    public List<MembreCategorie> getAllMembresCategories() {
        return membreCategorieRepository.findAll();
    }

    public MembreCategorie findById(Integer id) {
        return membreCategorieRepository.findByIdMembre(id);
    }
}
