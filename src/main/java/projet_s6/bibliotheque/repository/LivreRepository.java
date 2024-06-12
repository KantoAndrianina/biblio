package projet_s6.bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.Livre;
import projet_s6.bibliotheque.model.VLivreComplet;


@Repository
public interface LivreRepository extends JpaRepository<VLivreComplet, Integer> {

    @Query(value = "SELECT id_edition + id_auteur as sum FROM livre", nativeQuery = true)
    List<Integer> findLivreCollection();

    @Query(value = "SELECT id_edition + id_auteur as sum, numero_cote FROM livre", nativeQuery = true)
    List<Object[]> findSumAndNumeroCote();

    @Query("SELECT l FROM VLivreComplet l WHERE " +
        "LOWER(l.titre) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
        "LOWER(l.isbn) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
        "LOWER(l.nomCollection) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
        "LOWER(l.nomEdition) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
        "LOWER(l.nomAuteur) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
        "LOWER(l.numeroCote) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
        "LOWER(l.motsCle) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<VLivreComplet> searchLivres(@Param("query") String query);

    @Query("SELECT l FROM VLivreComplet as l WHERE l.idLivre = :id")
    VLivreComplet findLivreById(@Param("id") Integer id);
}
