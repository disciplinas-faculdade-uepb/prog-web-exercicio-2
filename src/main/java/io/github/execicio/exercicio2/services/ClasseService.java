package io.github.execicio.exercicio2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.execicio.exercicio2.controllers.ClasseController;
import io.github.execicio.exercicio2.controllers.TeacherController;
import io.github.execicio.exercicio2.data.vo.ClasseVO;
import io.github.execicio.exercicio2.exceptions.RequiredObjectIsNullException;
import io.github.execicio.exercicio2.exceptions.ResourceNotFoundException;
import io.github.execicio.exercicio2.mapper.DozerMapper;
import io.github.execicio.exercicio2.model.Classe;
import io.github.execicio.exercicio2.repositories.ClasseRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClasseService  {
  
  @Autowired
  ClasseRepository repository;

  public ClasseVO findById(Long id) {
    var entity = repository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("No found classes for this ID " + id));
    var vo = DozerMapper.parseObject(entity, ClasseVO.class);

    vo.add(
      linkTo(
        methodOn(ClasseController.class).findById(id)
      ).withSelfRel()
    );

    vo.add(
      linkTo(
        methodOn(TeacherController.class).findById(vo.getTeacher_id())
      ).withRel("teacher")
    );

    return vo;
  }

  public List<ClasseVO> findAll() {
    var classes = DozerMapper.parserListObjects(repository.findAll(), ClasseVO.class);

    classes
      .stream()
      .forEach(
        c -> {
          c.add(
            linkTo(
              methodOn(ClasseController.class).findById(c.getKey())
            ).withSelfRel()
          );

          c.add(
            linkTo(
              methodOn(TeacherController.class).findById(c.getTeacher_id())
            ).withRel("teacher")
          );
        }
      );

    return classes;
  }

  public ClasseVO create(ClasseVO classe) {

    if (classe == null) throw new RequiredObjectIsNullException();

    var entity = DozerMapper.parseObject(classe, Classe.class);
    var vo = DozerMapper.parseObject(repository.save(entity), ClasseVO.class);

    vo.add(
      linkTo(
        methodOn(ClasseController.class).findById(vo.getKey())
      ).withSelfRel()
    );

    vo.add(
      linkTo(
        methodOn(TeacherController.class).findById(vo.getTeacher_id())
      ).withRel("teacher")
    );

    return vo;
  }

  public ClasseVO update(ClasseVO classe) {

    if (classe == null) throw new RequiredObjectIsNullException();

    var entity = repository.findById(classe.getKey()).orElseThrow(
      () -> new ResourceNotFoundException("No records found for this ID " + classe.getKey())
    );

    entity.setDiscipline_name(classe.getDiscipline_name());
    entity.setRoom(classe.getRoom());
    entity.setTeacher_id(classe.getTeacher_id());

    var vo = DozerMapper.parseObject(repository.save(entity), ClasseVO.class);

    vo.add(
      linkTo(
        methodOn(ClasseController.class).findById(vo.getKey())
      ).withSelfRel()
    );

    vo.add(
      linkTo(
        methodOn(TeacherController.class).findById(vo.getTeacher_id())
      ).withRel("teacher")
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
