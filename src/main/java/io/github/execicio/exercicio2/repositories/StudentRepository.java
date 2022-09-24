package io.github.execicio.exercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.execicio.exercicio2.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
