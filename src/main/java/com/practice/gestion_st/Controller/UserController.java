package com.practice.gestion_st.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/utilisateurs")
	public String utilisateurs(Model modal) {
		return "users/utilisateurs";
	}
	
	@GetMapping("/utilisateurs/save")
	public String utilisateurs_save(Model modal) {
		return "users/utilisateurs_save";
	}
	
}
