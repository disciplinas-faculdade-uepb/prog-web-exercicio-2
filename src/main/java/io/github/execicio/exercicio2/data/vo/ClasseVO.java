package io.github.execicio.exercicio2.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "discipline_name", "room", "teacher_id" })
public class ClasseVO extends RepresentationModel<ClasseVO> implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @Mapping("id")
  private Long key;

  private Long teacher_id;
  private String discipline_name;
  private String room;

  public ClasseVO() {}

  public Long getKey() {
    return key;
  }

  public void setKey(Long key) {
    this.key = key;
  }

  public Long getTeacher_id() {
    return teacher_id;
  }

  public void setTeacher_id(Long teacher_id) {
    this.teacher_id = teacher_id;
  }

  public String getDiscipline_name() {
    return discipline_name;
  }

  public void setDiscipline_name(String discipline_name) {
    this.discipline_name = discipline_name;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((discipline_name == null) ? 0 : discipline_name.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((room == null) ? 0 : room.hashCode());
    result = prime * result + ((teacher_id == null) ? 0 : teacher_id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ClasseVO other = (ClasseVO) obj;
    if (discipline_name == null) {
      if (other.discipline_name != null)
        return false;
    } else if (!discipline_name.equals(other.discipline_name))
      return false;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    if (room == null) {
      if (other.room != null)
        return false;
    } else if (!room.equals(other.room))
      return false;
    if (teacher_id == null) {
      if (other.teacher_id != null)
        return false;
    } else if (!teacher_id.equals(other.teacher_id))
      return false;
    return true;
  }

}
