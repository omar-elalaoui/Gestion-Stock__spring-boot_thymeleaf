package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Dao.ClientRepository;
import com.practice.gestion_st.Entity.Client;
import com.practice.gestion_st.Service.Imp.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
	@Autowired
	ClientService clientService;
	@GetMapping("/clients")
	public String clients(Model model) {
		model.addAttribute("clients", clientService.findAll());
		return "clients/clients";
	}

	@GetMapping("/clients/form_add")
	public String clients_form_add(Model modal) {
		modal.addAttribute("client", new Client());
		return "clients/clients_save";
	}

	@GetMapping("/clients/form_update")
	public String clients_update(int id, Model model) {
		model.addAttribute("client", clientService.findById(id));
		return "clients/clients_save";
	}

	@PostMapping("/clients/save")
	public String clients_save(Client client, Model modal) {
		clientService.save(client);
		return "redirect:/clients";
	}
	@GetMapping("/clients/delete")
	public String clients_delete(int id, Model modal) {
		clientService.deleteById(id);
		return "redirect:/clients";
	}
	
	@GetMapping("/sorties")
	public String sorties(Model modal) {
		return "sorties/sorties";
	}
	
	@GetMapping("/sorties/nouvelle_commande")
	public String sortie_form(Model modal) {
		return "sorties/sorties_save";
	}
	
	@GetMapping("/facture_vente")
	public String facture_vente(Model modal) {
		return "facture_vente";
	}
}
