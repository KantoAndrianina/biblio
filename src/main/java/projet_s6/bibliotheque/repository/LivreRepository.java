package projet_s6.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {
    
}
