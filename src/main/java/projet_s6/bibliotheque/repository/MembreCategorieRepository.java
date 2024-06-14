package projet_s6.bibliotheque.repository;
import projet_s6.bibliotheque.model.Membre;
import projet_s6.bibliotheque.model.MembreCategorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MembreCategorieRepository extends JpaRepository<MembreCategorie, Integer> {

    @Query("SELECT m FROM MembreCategorie m WHERE LOWER(m.nomMembre) LIKE LOWER(CONCAT('%', :nom, '%'))")
    List<MembreCategorie> findByNomContainingIgnoreCase(@Param("nom") String nom);

    @Query("SELECT m FROM MembreCategorie as m WHERE m.idMembre = :id")
    MembreCategorie findByIdMembre(@Param("id") Integer id);

}