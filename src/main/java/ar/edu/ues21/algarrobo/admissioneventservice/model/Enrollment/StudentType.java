package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

public enum StudentType {
    NI("I"), RI("RI");

    private String oraValue;
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