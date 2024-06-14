package projet_s6.bibliotheque.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.Pret;
import projet_s6.bibliotheque.repository.PretRepository;

@Service
public class PretService {
    
    @Autowired
    private PretRepository pretRepository;

    public Pret creerPret(Date dateDebutPret, Date dateFinPret, Integer typePret, Integer idExemplaire, Integer pretIdMembre) {
        Pret pret = new Pret();
        pret.setDateDebutPret(dateDebutPret);
        pret.setDateFinPret(dateFinPret);
        pret.setIdTypePret(typePret);
        pret.setIdExemplaire(idExemplaire);
        pret.setIdMembre(pretIdMembre);

        return pretRepository.save(pret);
    }
}
