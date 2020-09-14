package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Site {
    private String id;
    private String name;
    private String code;
    private String location;
    private Long sedId;
    private Long siteId;
    private Long siteRefId;

    public String getType() {
        if (id != null) {
            if (id.startsWith("C")) {
                return "CAU";
            } else {
                return "SEDE";
            }
        }
        return null;
    }
}