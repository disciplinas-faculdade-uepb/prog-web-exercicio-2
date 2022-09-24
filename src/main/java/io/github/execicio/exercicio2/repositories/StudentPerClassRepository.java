package io.github.execicio.exercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.execicio.exercicio2.model.StudentPerClass;

@Repository
public interface StudentPerClassRepository extends JpaRepository<StudentPerClass, Long> {}
