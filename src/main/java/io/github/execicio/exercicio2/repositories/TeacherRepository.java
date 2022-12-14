package io.github.execicio.exercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.execicio.exercicio2.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
