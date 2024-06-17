package projet_s6.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.VPretDetail;
import projet_s6.bibliotheque.repository.PretDetailRepository;

@Service
public class PretDetailService {

    @Autowired
    private PretDetailRepository pretDetailRepository;
    
    public List<VPretDetail> findPretsEnCours() {
        return pretDetailRepository.findByDateRenduPretIsNull();
    }

    public List<VPretDetail> findPretsRendus() {
        return pretDetailRepository.findByDateRenduPretIsNotNull();
    }
}
