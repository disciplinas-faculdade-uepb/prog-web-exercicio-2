package io.github.execicio.exercicio2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_per_class", schema = "public")
public class StudentPerClass {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "classe_id", nullable = false)
  private Long classe_id;

  @Column(name = "student_id", nullable = false)
  private Long student_id;

  public StudentPerClass() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getClasse_id() {
    return classe_id;
  }

  public void setClasse_id(Long classe_id) {
    this.classe_id = classe_id;
  }

  public Long getStudent_id() {
    return student_id;
  }

  public void setStudent_id(Long student_id) {
    this.student_id = student_id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((classe_id == null) ? 0 : classe_id.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((student_id == null) ? 0 : student_id.hashCode());
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
    StudentPerClass other = (StudentPerClass) obj;
    if (classe_id == null) {
      if (other.classe_id != null)
        return false;
    } else if (!classe_id.equals(other.classe_id))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (student_id == null) {
      if (other.student_id != null)
        return false;
    } else if (!student_id.equals(other.student_id))
      return false;
    return true;
  }

}
