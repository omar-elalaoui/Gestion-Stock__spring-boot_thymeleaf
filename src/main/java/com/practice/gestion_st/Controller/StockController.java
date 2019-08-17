package com.practice.gestion_st.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
	
	@GetMapping("/journal")
	public String journal(Model modal) {
		return "journal";
	}
}
