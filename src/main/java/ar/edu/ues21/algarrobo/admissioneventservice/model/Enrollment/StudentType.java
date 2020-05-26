package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModelProperty;

public enum StudentType {
    NI("I"), RI("RI");

    @ApiModelProperty(example = "RI")
    private String oraValue;
    @ApiModelProperty(example = "R")
    private String sqlValue;

    StudentType(String val) {
      this.oraValue = val; 
      if (val.equals("RI")) {
          sqlValue = "R";
      } else { 
          sqlValue = "I";
      }
  }

  public String getOraValue() {
      return oraValue;
  }

  public String getSqlValue() {
      return sqlValue;
  }

  }