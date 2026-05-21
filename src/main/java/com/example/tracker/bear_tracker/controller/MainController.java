package com.example.tracker.bear_tracker.controller;

import com.example.tracker.bear_tracker.service.BalanceService;
import com.example.tracker.bear_tracker.service.ShopService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ShopService shopService;
    private final BalanceService balanceService;

    private static final String ADMIN_PASSWORD = "fuokolps123yyy";

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("balance", balanceService.getBalance());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("balance", balanceService.getBalance());
        model.addAttribute("items", shopService.getAllItems());
        return "shop";
    }

    @GetMapping("/admin-login")
    public String adminLogin() {
        return "admin-login";
    }

    @PostMapping("/admin-login")
    public String adminLoginPost(@RequestParam String password, HttpSession session) {
        if (ADMIN_PASSWORD.equals(password)) {
            session.setAttribute("admin", true);
            return "redirect:/admin";
        }

        return "redirect:/admin-login";
    }

    @GetMapping("/admin")
    public String admin(Model model, HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("admin"))) {
            return "redirect:/admin-login";
        }

        model.addAttribute("balance", balanceService.getBalance());
        return "admin";
    }

    @PostMapping("/admin/update-balance")
    public String updateBalance(@RequestParam Integer amount, HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("admin"))) {
            return "redirect:/admin-login";
        }

        balanceService.updateBalance(amount);
        return "redirect:/admin";
    }
}