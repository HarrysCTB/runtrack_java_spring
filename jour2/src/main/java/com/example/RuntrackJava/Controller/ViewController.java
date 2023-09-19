package com.example.RuntrackJava.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.Min;


class Utilisateur {

    private String nom;

    @Min(value = 18, message = "L'âge doit être d'au moins 18 ans.")
    private int age;

    // Getter pour le champ nom
    public String getNom() {
        return nom;
    }

    // Setter pour le champ nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour le champ age
    public int getAge() {
        return age;
    }

    // Setter pour le champ age
    public void setAge(int age) {
        this.age = age;
    }
}

@Controller
public class ViewController {

    @Min(value = 18, message = "L'âge doit être d'au moins 18 ans.")
    private int age;

    @GetMapping("/afficherFormulaire")
    public String afficherFormulaire(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "view";
    }

    @PostMapping("/afficherFormulaire")
    public String traiterFormulaire(Utilisateur utilisateur, Model model) {
        String message = "Bienvenue, " + utilisateur.getNom() + " !";
        model.addAttribute("message", message);
        return "view";
    }
}

