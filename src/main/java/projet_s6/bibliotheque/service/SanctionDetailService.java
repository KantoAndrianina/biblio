package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.VSanctionDetail;
import projet_s6.bibliotheque.repository.SanctionDetailRepository;

import java.util.List;

@Service
public class SanctionDetailService {

    @Autowired
    private SanctionDetailRepository repository;
   

    public List<VSanctionDetail> findAll() {
        return repository.findAll();
    }
}

