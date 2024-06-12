package projet_s6.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet_s6.bibliotheque.model.Admin;
import projet_s6.bibliotheque.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin login(String login, String password) throws Exception {
        Admin admin = adminRepository.findByLogin(login)
            .orElseThrow(() -> new Exception("Admin not found"));

        if (!admin.getMdp().equals(password)) {
            throw new Exception("Incorrect password");
        }

        return admin;
    }
}
