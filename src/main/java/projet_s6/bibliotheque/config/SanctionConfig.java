package projet_s6.bibliotheque.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import projet_s6.bibliotheque.service.SanctionService;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableScheduling
public class SanctionConfig {

    @Autowired
    private SanctionService sanctionService;

    // @Scheduled(cron = "0 0 0 * * ?") // A minuit tous les jours
    @Scheduled(fixedRate = 3600000) // Toutes les heures
    public void scheduleSanctionCheck() {
        sanctionService.checkAndApplySanctions();
    }
    
}
