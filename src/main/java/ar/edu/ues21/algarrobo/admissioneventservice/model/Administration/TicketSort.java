package ar.edu.ues21.algarrobo.admissioneventservice.model.Administration;

import io.swagger.annotations.ApiModelProperty;

public class TicketSort {

    @ApiModelProperty(name = "unsorted", example = "false")
    private Boolean unsorted;

    @ApiModelProperty(name = "sorted", example = "true")
    private Boolean sorted;

    @ApiModelProperty(name = "empty", example = "false")
    private Boolean empty;

    public Boolean getUnsorted() {
        return unsorted;
    }

    public void setUnsorted(Boolean unsorted) {
        this.unsorted = unsorted;
    }

    public Boolean getSorted() {
        return sorted;
    }

    public void setSorted(Boolean sorted) {
        this.sorted = sorted;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }
}
