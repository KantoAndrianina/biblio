package projet_s6.bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet_s6.bibliotheque.model.VAutorisationDetail;

public interface AutorisationDetailRepository extends JpaRepository<VAutorisationDetail, Integer> {
    
    List<VAutorisationDetail> findByIdLivre(Integer idLivre);
}
