package projet_s6.bibliotheque.repository;

import java.util.List;
import java.util.Date;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {

    @Query("SELECT p FROM Pret p WHERE p.dateFinPret < :date AND p.dateRenduPret IS NULL")
    List<Pret> findByDateFinPretBeforeAndDateRenduPretIsNull(@Param("date") Date date);

    @Query("SELECT p FROM Pret p WHERE p.dateRenduPret IS NULL")
    List<Pret> findByDateRenduPretIsNull();

}