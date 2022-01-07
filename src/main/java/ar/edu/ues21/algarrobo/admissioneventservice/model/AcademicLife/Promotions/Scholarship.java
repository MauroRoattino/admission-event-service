package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Promotions;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Scholarship {

    @ApiModelProperty(name = "id", example = "f8d11140-13ef-49c9-b34e-198fb018133b")
    private String id;

    @ApiModelProperty(name = "name", example = "Beneficio alto rendimiento")
    private String name;

    @ApiModelProperty(name = "description", example = "Alto rendimiento para estudiantes de GRADO")
    private String description;

    @ApiModelProperty(name = "concept", example = "MM")
    private String concept;

    @ApiModelProperty(name = "state", example = "ACTIVE")
    private String state;

    @ApiModelProperty(name = "studentType", example = "RI")
    private String studentType;

    @ApiModelProperty(name = "value", example = "10")
    private int value;

    @ApiModelProperty(name = "studyClass", example = "1")
    private int studyClass;

    @ApiModelProperty(name = "gradePointAverage", example = "7")
    private int gradePointAverage;

    @ApiModelProperty(name = "sanctions", example = "false")
    private Boolean sanctions;

    @ApiModelProperty(name = "failingGrades", example = "0")
    private int failingGrades;

    @ApiModelProperty(name = "extend", example = "true")
    private Boolean extend;

    @ApiModelProperty(name = "type", example = "BENEFIT")
    private String type;

    @ApiModelProperty(name = "originId", example = "1306")
    private int originId;

    @ApiModelProperty(name = "documents")
    private List<Document> documents;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(int studyClass) {
        this.studyClass = studyClass;
    }

    public int getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(int gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public Boolean getSanctions() {
        return sanctions;
    }

    public void setSanctions(Boolean sanctions) {
        this.sanctions = sanctions;
    }

    public int getFailingGrades() {
        return failingGrades;
    }

    public void setFailingGrades(int failingGrades) {
        this.failingGrades = failingGrades;
    }

    public Boolean getExtend() {
        return extend;
    }

    public void setExtend(Boolean extend) {
        this.extend = extend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
