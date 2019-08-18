package com.practice.gestion_st.Controller;

import com.practice.gestion_st.Entity.Role;
import com.practice.gestion_st.Entity.User;
import com.practice.gestion_st.Service.Imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/utilisateurs")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("")
	public String utilisateurs(Model model) {
		List<User> users= userService.findAll();
		User u= users.get(0);
		users.remove(u);
		
		model.addAttribute("users", users);
		return "users/utilisateurs";
	}
	
	@GetMapping("/user_form")
	public String user_form(Model model) {
		model.addAttribute("user", new User());
		return "users/utilisateurs_save";
	}
	
	@GetMapping("/form_update")
	public String form_update(String user, Model model) {
		
		return "users/utilisateurs_save";
	}
	
	@GetMapping("/delete")
	public String delete(String user, Model model) {
		userService.deleteById(user);
		//userService.deleteRoleRelationship(user);
		return "redirect:/utilisateurs";
	}
	
	
	@PostMapping("/save")
	public String utilisateurs_save(User user, Model model) {
		List<Role> roles= new ArrayList<Role>();
		Role user_role= new Role();
		user_role.setRole("USER");
		roles.add(user_role);
		user.setRoles(roles);
		user.setPwd(passwordEncoder.encode(user.getPwd()));
		user.setActive(true);
		userService.save(user);
		return "redirect:/utilisateurs";
	}
	
}
