package com.practice.gestion_st.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("/accueil")
    public String accueila(Model model){
        return "accueil";
    }
    @GetMapping("/")
    public String accueil(Model model){ return "redirect:/accueil";
    }
}
