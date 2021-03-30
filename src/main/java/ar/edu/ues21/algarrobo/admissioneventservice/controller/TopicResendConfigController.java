package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.BlacklistOperation;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ResendService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/v1")
public class TopicResendConfigController {

    private final ResendService resendService;

    public TopicResendConfigController(ResendService resendService) {
        this.resendService = resendService;
    }

    @PutMapping("/blacklist/{topicName}")
    @ApiOperation(value = "Activate/deactivate resends for a certain topic")
    public ResponseEntity modifyTopicBlacklist(
            @Valid @RequestBody BlacklistOperation operation,
            @PathVariable String topicName) {
        if (operation.isActivate()) {
            this.resendService.removeTopicFromBlacklist(topicName.toLowerCase());
        } else {
            this.resendService.addTopicToBlacklist(topicName.toLowerCase());
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/blacklist")
    @ApiOperation(value = "Get topics with deactivated resends")
    public ResponseEntity<List<String>> getTopicsInBlacklist() {
        List<String> topicsWithDeactivatedResends = this.resendService.getResendBlacklist();
        return ResponseEntity.ok(topicsWithDeactivatedResends);
    }


}
