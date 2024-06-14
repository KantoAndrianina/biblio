package projet_s6.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet_s6.bibliotheque.model.Membre;

import java.util.List;

public interface MembreRepository extends JpaRepository<Membre, Integer> {
    
    @Query("SELECT m FROM Membre m WHERE lower(m.nomMembre) = lower(:nomMembre)")
    Membre findByNomMembreIgnoreCase(@Param("nomMembre") String nomMembre);
}
