package projet_s6.bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.AutorisationException;

@Repository
public interface AutorisationExceptionRepository extends JpaRepository<AutorisationException, Integer> {

    List<AutorisationException> findByIdLivre(Integer idLivre);
}
