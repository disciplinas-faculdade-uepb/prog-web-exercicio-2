package io.github.execicio.exercicio2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.execicio.exercicio2.data.vo.StudentPerClassVO;
import io.github.execicio.exercicio2.exceptions.RequiredObjectIsNullException;
import io.github.execicio.exercicio2.mapper.DozerMapper;
import io.github.execicio.exercicio2.model.StudentPerClass;
import io.github.execicio.exercicio2.repositories.StudentPerClassRepository;

@Service
public class StudentPerClassService {
  
  @Autowired
  StudentPerClassRepository repository;

  public StudentPerClassVO create(StudentPerClassVO studentPerClass) {

    if (studentPerClass == null) throw new RequiredObjectIsNullException();

    var entity = DozerMapper.parseObject(studentPerClass, StudentPerClass.class);
    var vo = DozerMapper.parseObject(repository.save(entity), StudentPerClassVO.class);

    return vo;
  }

}
