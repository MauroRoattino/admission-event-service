package ar.edu.ues21.algarrobo.admissioneventservice.model.User.Career;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserCareer {
    private String code;
    private boolean edn;
    private Long id;

    @ApiModelProperty(name = "level", example = "DEGREE")
    private String level;
    private String name;
    private List<CareerPlans> plans;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEdn() {
        return edn;
    }

    public void setEdn(boolean edn) {
        this.edn = edn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CareerPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<CareerPlans> plans) {
        this.plans = plans;
    }
}
