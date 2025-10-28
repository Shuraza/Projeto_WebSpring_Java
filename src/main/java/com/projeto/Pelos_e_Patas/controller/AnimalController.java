package com.projeto.Pelos_e_Patas.controller;


import com.projeto.Pelos_e_Patas.entity.Animal;
import com.projeto.Pelos_e_Patas.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("animais", service.listarTodos());
        return "animais";
    }

    @PostMapping
    public String salvar(Animal animal) {
        service.salvar(animal);
        return "redirect:/animais";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/animais";
    }

}
