package projet_s6.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import projet_s6.bibliotheque.model.Admin;
import projet_s6.bibliotheque.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/login")
    public String showLoginPage() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam String login, @RequestParam String mdp, HttpSession session, Model model) {
        try {
            Admin admin = adminService.login(login, mdp);
            session.setAttribute("adminId", admin.getIdAdmin());
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login";
        }
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard(@SessionAttribute("adminId") Long adminId, Model model) {
        model.addAttribute("adminId", adminId);
        return "admin/dashboard";
    }
}

