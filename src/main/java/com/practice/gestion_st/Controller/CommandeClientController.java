package com.practice.gestion_st.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sorties")
public class CommandeClientController {
    @GetMapping("")
    public String sorties(Model modal) {
        return "sorties/sorties";
    }

    @GetMapping("/nouvelle_commande")
    public String sortie_form(Model modal) {
        return "sorties/sorties_save";
    }


}
