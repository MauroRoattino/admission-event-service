package ar.edu.ues21.algarrobo.admissioneventservice.model.Administration;

import io.swagger.annotations.ApiModelProperty;

public class TicketPageable {
    private TicketSort sort;

    @ApiModelProperty(name = "pageSize", example = "20")
    private Integer pageSize;

    @ApiModelProperty(name = "pageNumber", example = "0")
    private Integer pageNumber;

    @ApiModelProperty(name = "offset", example = "0")
    private Integer offset;

    @ApiModelProperty(name = "unpaged", example = "false")
    private Boolean unpaged;

    @ApiModelProperty(name = "paged", example = "true")
    private Boolean paged;

    public TicketSort getSort() {
        return sort;
    }

    public void setSort(TicketSort sort) {
        this.sort = sort;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Boolean getUnpaged() {
        return unpaged;
    }

    public void setUnpaged(Boolean unpaged) {
        this.unpaged = unpaged;
    }

    public Boolean getPaged() {
        return paged;
    }

    public void setPaged(Boolean paged) {
        this.paged = paged;
    }
}
