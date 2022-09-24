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

import io.github.execicio.exercicio2.data.vo.TeacherVO;
import io.github.execicio.exercicio2.services.TeacherService;
import io.github.execicio.exercicio2.utils.MediaTypes;

@RestController
@RequestMapping("/api/v1/professores")
public class TeacherController {
  
  @Autowired
  private TeacherService serviceTeacher;

  @PostMapping(
    consumes = { MediaTypes.APPLICATION_JSON },
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public TeacherVO create(@RequestBody TeacherVO teacher) {
    return serviceTeacher.create(teacher);
  }

  @PutMapping(
    value = "/{id}",
    consumes = { MediaTypes.APPLICATION_JSON },
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public TeacherVO update(
    @RequestBody TeacherVO teacher,
    @PathVariable(value = "id") Long id
  ) {
    teacher.setKey(id);
    return serviceTeacher.update(teacher);
  }

  @GetMapping(
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public List<TeacherVO> findAll() {
    return serviceTeacher.findAll();
  }

  @GetMapping(
    value = "/{id}",
    produces = { MediaTypes.APPLICATION_JSON }
  )
  public TeacherVO findById(@PathVariable(value = "id") Long id) {
    return serviceTeacher.findById(id);
  }

  @DeleteMapping(
    value = "/{id}"
  )
  public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
    serviceTeacher.delete(id);
    return ResponseEntity.noContent().build();
  }

}
