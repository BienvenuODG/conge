package com.conge.conge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conge.conge.model.User;
import com.conge.conge.repository.RoleRepository;
import com.conge.conge.repository.UserRepository;
import com.conge.conge.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    // @Autowired
    private UserService userService;
    // @Autowired
    private RoleRepository roleRepository;
    // private UserRepository userRepository;
    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
        return "user-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "user-form";
    }
    @GetMapping("/modifier/{id}")
    public String modifierUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "modifier_utilisateur";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users/list";
    }

    private final UserService userService2;
    //lien de page html connexion
    @GetMapping("/connexion")
    public String showLoginForm() {
        return "user_connexion"; // correspond à templates/connexion.html
    }

    // @GetMapping("/connexion")
    // public String showLoginForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("user", userService.findById(id));
    //     model.addAttribute("roles", roleRepository.findAll());
    //     return "user_connexion";
    // }
    // connexion utilisateur
    // @PostMapping("/login")
    // public String login(@RequestParam String email, @RequestParam String password, Model model) {
    //     User user = userService2.findByEmailAndPassword(email, password);
    //     if (user != null) {
    //         model.addAttribute("user", user);
    //         return "redirect:/users/list"; // la vue profile.html
    //     } else {
    //         model.addAttribute("error", "Identifiants incorrects !");
    //         return "user_connexion";
    //     }
    // }
}

