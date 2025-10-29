package com.projeto.Pelos_e_Patas.controller;

import com.projeto.Pelos_e_Patas.entity.Animal;
import com.projeto.Pelos_e_Patas.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "animais-listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("animal", new Animal());
        return "animais-cadastrar";
    }

    @PostMapping
    public String salvar(@ModelAttribute Animal animal) {
        service.salvar(animal);
        return "redirect:/animais";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/animais";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Animal animal = service.buscarId(id);
        model.addAttribute("animal", animal);
        return "animais-editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Animal animal) {
        service.salvar(animal);
        return "redirect:/animais";
    }
}
