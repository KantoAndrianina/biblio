package projet_s6.bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.LivreEmprunt;
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

    @Query("SELECT l FROM VLivreComplet as l WHERE l.code = :code")
    VLivreComplet findLivreByCode(@Param("code") String code);

    @Query(value = "SELECT MIN(ex.id_exemplaire) AS id_exemplaire " +
                   "FROM v_exemplaire_livres ex " +
                   "LEFT JOIN v_prets p ON ex.id_exemplaire = p.id_exemplaire AND p.date_rendu_pret IS NULL " +
                   "WHERE ex.id_livre = :idLivre " +
                   "AND p.id_pret IS NULL",
           nativeQuery = true)
    Integer findExemplaireRestant(@Param("idLivre") Integer idLivre);

}
