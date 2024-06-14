package projet_s6.bibliotheque.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<Pret> getPretsEnCours() {
        return pretRepository.findByDateRenduPretIsNull();
    }

    public void rendrePret(Integer idPret) {
        Optional<Pret> optionalPret = pretRepository.findById(idPret);
        if (optionalPret.isPresent()) {
            Pret pret = optionalPret.get();
            pret.setDateRenduPret(new Date());
            pretRepository.save(pret);
        } else {
            throw new RuntimeException("Pret not found");
        }
    }
}
