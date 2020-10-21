package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus.SubjectStatusType;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class SubjectStatusType {
    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    private SubjectId subjectId;

    @ApiModelProperty(name = "name", example = "ALL EXAMS")
    private String name;

    private List<SubjectStatusTypeFlag> flags;

    public SubjectId getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(SubjectId subjectId) {
        this.subjectId = subjectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectStatusTypeFlag> getFlags() {
        return flags;
    }

    public void setFlags(List<SubjectStatusTypeFlag> flags) {
        this.flags = flags;
    }
}
