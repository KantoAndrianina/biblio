package projet_s6.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.Sanction;

import java.util.Optional;
import java.util.Date;


@Repository
public interface SanctionRepository extends JpaRepository<Sanction, Integer> {

   @Query("SELECT s FROM Sanction s WHERE s.idMembre = :idMembre AND s.dateFinSanction > :currentDate")
    Optional<Sanction> findByIdMembreAndDateFinSanctionAfter(@Param("idMembre") Integer idMembre, @Param("currentDate") Date currentDate);

    @Query("SELECT COUNT(s) > 0 FROM Sanction s WHERE s.idMembre = :idMembre AND s.dateFinSanction > :date")
    boolean existsByIdMembreAndDateFinSanctionAfter(@Param("idMembre") Integer idMembre, @Param("date") Date date);
}
