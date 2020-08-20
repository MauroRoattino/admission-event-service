package ar.edu.ues21.algarrobo.admissioneventservice.model.Administration;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TicketData {

    private List<TicketContent> content;

    private TicketPageable pageable;

    @ApiModelProperty(name = "totalPages", example = "2")
    private Integer totalPages;

    @ApiModelProperty(name = "totalElements", example = "32")
    private Integer totalElements;

    @ApiModelProperty(name = "last", example = "false")
    private Boolean last;

    private TicketSort sort;

    @ApiModelProperty(name = "numberOfElements", example = "20")
    private Integer numberOfElements;

    @ApiModelProperty(name = "first", example = "true")
    private Boolean first;

    @ApiModelProperty(name = "size", example = "20")
    private Integer size;

    @ApiModelProperty(name = "number", example = "0")
    private Integer number;

    @ApiModelProperty(name = "empty", example = "false")
    private Boolean empty;

    public List<TicketContent> getContent() {
        return content;
    }

    public void setContent(List<TicketContent> content) {
        this.content = content;
    }

    public TicketPageable getPageable() {
        return pageable;
    }

    public void setPageable(TicketPageable pageable) {
        this.pageable = pageable;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public TicketSort getSort() {
        return sort;
    }

    public void setSort(TicketSort sort) {
        this.sort = sort;
    }

    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }
}
