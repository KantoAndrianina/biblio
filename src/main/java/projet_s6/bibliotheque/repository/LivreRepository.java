package projet_s6.bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    @Query(value = "SELECT id_edition + id_auteur as sum FROM livre", nativeQuery = true)
    List<Integer> findLivreCollection();

    @Query(value = "SELECT id_edition + id_auteur as sum, numero_cote FROM livre", nativeQuery = true)
    List<Object[]> findSumAndNumeroCote();
}
