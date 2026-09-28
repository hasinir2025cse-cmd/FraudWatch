package com.fraudwatch.controller;

import com.fraudwatch.model.Transaction;
import com.fraudwatch.service.FraudService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final FraudService service;

    public HomeController(FraudService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {

        int total = service.list.size();
        int flagged = 0;

        for (Transaction t : service.list) {
            if ("FLAGGED".equals(t.getStatus())) {
                flagged++;
            }
        }

        model.addAttribute("list", service.list);
        model.addAttribute("tx", new Transaction());
        model.addAttribute("total", total);
        model.addAttribute("flagged", flagged);
        model.addAttribute("normal", total - flagged);

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Transaction t) {
        service.add(t);
        return "redirect:/";
    }
}