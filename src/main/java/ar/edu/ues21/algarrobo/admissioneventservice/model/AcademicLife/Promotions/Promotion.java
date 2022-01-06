package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Promotions;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Promotion {

    @ApiModelProperty(name = "id", example = "f8d11140-13ef-49c9-b34e-198fb018133b")
    private String id;

    @ApiModelProperty(name = "scholarship")
    private Scholarship scholarship;

    @ApiModelProperty(name = "name", example = "promoción comercial campaña 2018")
    private String name;

    @ApiModelProperty(name = "description", example = "promoción campaña 2018")
    private String description;

    @ApiModelProperty(name = "type", example = "COUPON")
    private String type;

    @ApiModelProperty(name = "studentType", example = "NI")
    private String studentType;

    @ApiModelProperty(name = "value", example = "20")
    private int value;

    @ApiModelProperty(name = "valueType", example = "ADDITIVE_PERCENTAGE")
    private String valueType;

    @ApiModelProperty(name = "start", example = "2019-06-31")
    private String start;

    @ApiModelProperty(name = "end", example = "2020-06-31")
    private String end;

    @ApiModelProperty(name = "state", example = "ACTIVE")
    private String state;

    @ApiModelProperty(name = "period")
    private Period period;

    @ApiModelProperty(name = "productTypes")
    private List<ProductType> productTypes;

    @ApiModelProperty(name = "arguments")
    private List<Arguments> arguments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Scholarship getScholarship() {
        return scholarship;
    }

    public void setScholarship(Scholarship scholarship) {
        this.scholarship = scholarship;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    public List<Arguments> getArguments() {
        return arguments;
    }

    public void setArguments(List<Arguments> arguments) {
        this.arguments = arguments;
    }
}
