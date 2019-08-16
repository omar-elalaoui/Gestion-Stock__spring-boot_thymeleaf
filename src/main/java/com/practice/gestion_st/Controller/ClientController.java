package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Dao.ClientRepository;
import com.practice.gestion_st.Entity.Client;
import com.practice.gestion_st.Service.Imp.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("")
	public String clients(Model model) {
		model.addAttribute("clients", clientService.findAll());
		return "clients/clients";
	}

	@GetMapping("/form_add")
	public String clients_form_add(Model modal) {
		modal.addAttribute("client", new Client());
		return "clients/clients_save";
	}

	@GetMapping("/form_update")
	public String clients_update(int id, Model model) {
		model.addAttribute("client", clientService.findById(id));
		return "clients/clients_save";
	}

	@PostMapping("/save")
	public String clients_save(Client client, Model modal) {
		clientService.save(client);
		return "redirect:/clients";
	}
	@GetMapping("/delete")
	public String clients_delete(int id, Model modal) {
		clientService.deleteById(id);
		return "redirect:/clients";
	}

}
