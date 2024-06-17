package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.AutorisationException;
import projet_s6.bibliotheque.model.VAutorisationDetail;
import projet_s6.bibliotheque.repository.AutorisationDetailRepository;

import java.util.List;

@Service
public class AutorisationDetailService {

    @Autowired
    private AutorisationDetailRepository autorisationDetailRepository;

    public List<VAutorisationDetail> getAllAutorisationDetails() {
        return autorisationDetailRepository.findAll();
    }

     public List<VAutorisationDetail> findAutorisationDetailByLivreId(Integer idLivre) {
        return autorisationDetailRepository.findByIdLivre(idLivre);
    }

    // Ajoutez d'autres méthodes de service si nécessaire
}
