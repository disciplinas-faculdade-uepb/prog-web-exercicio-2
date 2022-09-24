package io.github.execicio.exercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.execicio.exercicio2.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {}
