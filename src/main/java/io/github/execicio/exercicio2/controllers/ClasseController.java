package io.github.execicio.exercicio2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.execicio.exercicio2.data.vo.ClasseVO;
import io.github.execicio.exercicio2.data.vo.StudentPerClassVO;
import io.github.execicio.exercicio2.services.ClasseService;
import io.github.execicio.exercicio2.services.StudentPerClassService;
import io.github.execicio.exercicio2.utils.MediaTypes;

@RestController
@RequestMapping("/api/v1/turmas")
public class ClasseController {
  
  @Autowired
  ClasseService service;

  @Autowired
  private StudentPerClassService serviceStudentPerClass;

  @GetMapping(
    value = "/{id}",
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public ClasseVO findById(@PathVariable(value = "id") Long id) {
    return service.findById(id);
  }

  @GetMapping(
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public List<ClasseVO> findAll() {
    return service.findAll();
  }

  @PostMapping(
    consumes = { MediaTypes.APPLICATION_JSON },
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public ClasseVO create(@RequestBody ClasseVO classe) {
    return service.create(classe);
  }

  @PutMapping(
    value = "/{id}",
    consumes = { MediaTypes.APPLICATION_JSON },
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public ClasseVO update(
    @PathVariable(value = "id") Long id, @RequestBody ClasseVO classe
  ) {
    classe.setKey(id);
    return service.update(classe);
  }

  @DeleteMapping(
    value = "/{id}"
  )
  public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping(
    value = "/{turmaId}/matricularAluno/{alunoId}"
  )
  public StudentPerClassVO relationClassesRegister(
    @PathVariable(value = "turmaId") Long turmaId,
    @PathVariable(value = "alunoId") Long alunoId
  ) {
    StudentPerClassVO studentPerClass = new StudentPerClassVO();
    studentPerClass.setClasse_id(turmaId);
    studentPerClass.setStudent_id(alunoId);
    return serviceStudentPerClass.create(studentPerClass);
  }

}
