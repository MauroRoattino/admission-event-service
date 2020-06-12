package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(example = "92448")
    private Long id;

    @ApiModelProperty(example = "OLIOTTA")
    private String usrPortal;

    @ApiModelProperty(example = "S")
    private String active;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @ApiModelProperty(example = "2019-03-20T03:00:00Z")
    private LocalDateTime fromDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @ApiModelProperty(example = "2019-03-20T03:00:00Z")
    private LocalDateTime passwordExpiration;
}