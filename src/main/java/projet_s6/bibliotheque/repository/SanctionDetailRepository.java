package projet_s6.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet_s6.bibliotheque.model.VSanctionDetail;

@Repository
public interface SanctionDetailRepository extends JpaRepository<VSanctionDetail, Integer> {
}
