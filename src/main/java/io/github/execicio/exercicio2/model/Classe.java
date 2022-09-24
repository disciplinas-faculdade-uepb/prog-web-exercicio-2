package io.github.execicio.exercicio2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes", schema = "public")
public class Classe {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "teacher_id", nullable = false)
  private Long teacher_id;

  @Column(name = "discipline_name", nullable = false)
  private String discipline_name;

  @Column(name = "room", nullable = false)
  private String room;

  public Classe() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    int result = 1;
    result = prime * result + ((discipline_name == null) ? 0 : discipline_name.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((room == null) ? 0 : room.hashCode());
    result = prime * result + ((teacher_id == null) ? 0 : teacher_id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Classe other = (Classe) obj;
    if (discipline_name == null) {
      if (other.discipline_name != null)
        return false;
    } else if (!discipline_name.equals(other.discipline_name))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
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
