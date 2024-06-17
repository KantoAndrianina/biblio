package projet_s6.bibliotheque.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet_s6.bibliotheque.model.VPretDetail;

@Repository
public interface PretDetailRepository extends JpaRepository<VPretDetail, Integer> {
    // Ajoutez des méthodes de requête personnalisées ici si nécessaire
    List<VPretDetail> findByDateRenduPretIsNull();

    List<VPretDetail> findByDateRenduPretIsNotNull();
}
