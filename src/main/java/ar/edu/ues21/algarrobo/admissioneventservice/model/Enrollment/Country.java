package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel("Countries")
@Entity
@Table(name = "UE_PAISES", schema = "UE21")
public class Country implements Serializable {

  private static final long serialVersionUID = 1095371181744300551L;

  @ApiModelProperty(value = "country's id", example = "4")
  @Id
  @Column(name = "ID")
  private Long id;

  @ApiModelProperty(value = "country's name", example = "ARGENTINA")
  @Column(name = "DESCRIPCION")
  private String name;

  @ApiModelProperty(value = "country's nationality", example = "ARGENTINA")
  @Column(name = "NACIONALIDAD")
  private String nationality;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getNationality() {
    return nationality;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
}
