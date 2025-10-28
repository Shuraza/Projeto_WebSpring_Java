package com.projeto.Pelos_e_Patas.service;


import com.projeto.Pelos_e_Patas.entity.Animal;
import com.projeto.Pelos_e_Patas.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalService {
  private final AnimalRepository repository;
  public AnimalService(AnimalRepository repository) {
      this.repository = repository;
  }

  public List<Animal> listarTodos() {
      return repository.findAll();
  }

  public Animal salvar(Animal animal) {
    return repository.save(animal);
  }

  public void excluir(Long id) {
    repository.deleteById(id);
  }

  public Animal buscarId(Long id) {
    return repository.findById(id).orElse(null);
  }

}
