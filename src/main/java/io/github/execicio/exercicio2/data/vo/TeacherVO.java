package io.github.execicio.exercicio2.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "name", "mail", "formation", "register" })
public class TeacherVO extends RepresentationModel<TeacherVO> implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @Mapping("id")
  private Long key;

  private String name;
  private String mail;
  private String formation;
  private String register;

  public TeacherVO() {}

  public Long getKey() {
    return key;
  }

  public void setKey(Long key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getFormation() {
    return formation;
  }

  public void setFormation(String formation) {
    this.formation = formation;
  }

  public String getRegister() {
    return register;
  }

  public void setRegister(String register) {
    this.register = register;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((formation == null) ? 0 : formation.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((register == null) ? 0 : register.hashCode());
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
    TeacherVO other = (TeacherVO) obj;
    if (formation == null) {
      if (other.formation != null)
        return false;
    } else if (!formation.equals(other.formation))
      return false;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    if (mail == null) {
      if (other.mail != null)
        return false;
    } else if (!mail.equals(other.mail))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (register == null) {
      if (other.register != null)
        return false;
    } else if (!register.equals(other.register))
      return false;
    return true;
  }

}
