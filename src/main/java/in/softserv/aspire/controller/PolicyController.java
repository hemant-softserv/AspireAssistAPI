package in.softserv.aspire.controller;

import in.softserv.aspire.dto.APIResponseDTO;
import in.softserv.aspire.dto.PolicyDTO;
import in.softserv.aspire.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/policy"})
public class PolicyController {
    private final Logger logger = LoggerFactory.getLogger(PolicyController.class);
    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<APIResponseDTO> createPolicy(@RequestBody PolicyDTO dto) {
        this.logger.info("In Policy Controller -> Create Policy");
        APIResponseDTO newDTO = this.service.createPolicy(dto);
        return new ResponseEntity<>(newDTO, HttpStatus.valueOf(newDTO.getStatusCode() == 0 ? 200 : newDTO.getStatusCode()));
    }
}
