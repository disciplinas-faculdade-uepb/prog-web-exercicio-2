package io.github.execicio.exercicio2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.execicio.exercicio2.data.vo.StudentVO;
import io.github.execicio.exercicio2.services.StudentService;
import io.github.execicio.exercicio2.utils.MediaTypes;

@RestController
@RequestMapping("/api/v1/alunos")
public class StudentController {
  
  @Autowired
  StudentService serviceStudent;

  @GetMapping(
    value = "/{id}",
    produces = {  MediaTypes.APPLICATION_JSON }
  )
  public StudentVO findById(@PathVariable(value = "id") Long id) {
    return serviceStudent.findById(id);
  }

  @GetMapping(
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public List<StudentVO> findAll() {
    return serviceStudent.findAll();
  }

  @PostMapping(
    consumes = { MediaTypes.APPLICATION_JSON },
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public StudentVO create(@RequestBody StudentVO student) {
    return serviceStudent.create(student);
  }

  @PutMapping(
    value = "/{id}",
    consumes = { MediaTypes.APPLICATION_JSON },
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public StudentVO update(
    @PathVariable(value = "id") Long id, @RequestBody StudentVO student
  ) {
    student.setKey(id);
    return serviceStudent.update(student);
  }

  @DeleteMapping(
    value = "/{id}"
  )
  public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
    serviceStudent.delete(id);
    return ResponseEntity.noContent().build();
  }

}
