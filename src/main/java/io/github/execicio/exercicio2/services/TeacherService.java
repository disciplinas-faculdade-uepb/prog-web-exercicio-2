package io.github.execicio.exercicio2.services;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.execicio.exercicio2.controllers.TeacherController;
import io.github.execicio.exercicio2.data.vo.TeacherVO;
import io.github.execicio.exercicio2.exceptions.RequiredObjectIsNullException;
import io.github.execicio.exercicio2.exceptions.ResourceNotFoundException;
import io.github.execicio.exercicio2.mapper.DozerMapper;
import io.github.execicio.exercicio2.model.Teacher;
import io.github.execicio.exercicio2.repositories.TeacherRepository;

@Service
public class TeacherService {
  
  @Autowired
  TeacherRepository repository;

  public TeacherVO create(TeacherVO teacher) {
    if (teacher == null) throw new RequiredObjectIsNullException();

    var entity = DozerMapper.parseObject(teacher, Teacher.class);
    var vo = DozerMapper.parseObject(repository.save(entity), TeacherVO.class);

    vo.add(
      linkTo(
        methodOn(TeacherController.class).findById(vo.getKey())
      ).withSelfRel()
    );

    return vo;
  }

  public List<TeacherVO> findAll() {
    var teachers = DozerMapper.parserListObjects(repository.findAll(), TeacherVO.class);
    
    teachers
      .stream()
      .forEach(
        t -> 
          t.add(
            linkTo(
              methodOn(TeacherController.class).findById(t.getKey())
            ).withSelfRel()
          )
      );

    return teachers;
  }

  public TeacherVO findById(Long id) {
    var entity = repository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("No found classes for this ID " + id));
    var vo = DozerMapper.parseObject(entity, TeacherVO.class);

    vo.add(
      linkTo(
        methodOn(TeacherController.class).findById(vo.getKey())
      ).withSelfRel()
    );

    return vo;
  }

  public TeacherVO update(TeacherVO teacher) {

    if (teacher == null) throw new RequiredObjectIsNullException();

    var entity = repository.findById(teacher.getKey()).orElseThrow(
      () -> new ResourceNotFoundException("No records found for this ID " + teacher.getKey())
    );

    entity.setName(teacher.getName());
    entity.setMail(teacher.getMail());
    entity.setFormation(teacher.getFormation());
    entity.setRegister(teacher.getRegister());

    var vo = DozerMapper.parseObject(repository.save(entity), TeacherVO.class);

    vo.add(
      linkTo(
        methodOn(TeacherController.class).findById(vo.getKey())
      ).withSelfRel()
    );

    return vo;
  }

  public void delete(Long id) {
    var entity = repository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("No records found for this ID " + id)
    );

    repository.delete(entity);
  }

}
