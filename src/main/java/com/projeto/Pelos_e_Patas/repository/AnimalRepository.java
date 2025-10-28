package com.projeto.Pelos_e_Patas.repository;

import com.projeto.Pelos_e_Patas.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
