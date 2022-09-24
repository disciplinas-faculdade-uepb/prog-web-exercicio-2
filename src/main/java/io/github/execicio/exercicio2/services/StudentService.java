package io.github.execicio.exercicio2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.execicio.exercicio2.controllers.StudentController;
import io.github.execicio.exercicio2.data.vo.StudentVO;
import io.github.execicio.exercicio2.exceptions.RequiredObjectIsNullException;
import io.github.execicio.exercicio2.exceptions.ResourceNotFoundException;
import io.github.execicio.exercicio2.mapper.DozerMapper;
import io.github.execicio.exercicio2.model.Student;
import io.github.execicio.exercicio2.repositories.StudentRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class StudentService {
  
  @Autowired
  StudentRepository repository;

  public StudentVO findById(Long id) {

    var entity = repository.findById(id)
      .orElseThrow(
        () -> new ResourceNotFoundException("No found student for this ID " + id)
      );

    var vo = DozerMapper.parseObject(entity, StudentVO.class);

    vo.add(
      linkTo(
        methodOn(StudentController.class).findById(id)
      ).withSelfRel()
    );

    return vo;
  }

  public List<StudentVO> findAll() {
    var students = DozerMapper.parserListObjects(repository.findAll(), StudentVO.class);

    students
      .stream()
      .forEach(
        s -> s.add(
          linkTo(
            methodOn(StudentController.class).findById(s.getKey())
          ).withSelfRel()
        )
      );

    return students;
  }

  public StudentVO create(StudentVO student) {
    if (student == null) throw new RequiredObjectIsNullException();

    var entity = DozerMapper.parseObject(student, Student.class);
    var vo = DozerMapper.parseObject(repository.save(entity), StudentVO.class);

    vo.add(
      linkTo(
        methodOn(StudentController.class).findById(vo.getKey())
      ).withSelfRel()
    );

    return vo;
  }

  public StudentVO update(StudentVO student) {
    if (student == null) throw new RequiredObjectIsNullException();

    var entity = repository.findById(student.getKey())
      .orElseThrow(
        () -> new ResourceNotFoundException("No records found for this ID " + student.getKey())
      );

    entity.setName(student.getName());
    entity.setMail(student.getMail());
    entity.setRegister(student.getRegister());

    var vo = DozerMapper.parseObject(repository.save(entity), StudentVO.class);

    vo.add(
      linkTo(
        methodOn(StudentController.class).findById(vo.getKey())
      ).withSelfRel()
    );

    return vo;
  }

  public void delete(Long id) {
    var entity = repository.findById(id)
      .orElseThrow(
        () -> new ResourceNotFoundException("No records found for this ID " + id)
      );
    
    repository.delete(entity);
  }

}
