package in.softserv.aspire.controller;

import in.softserv.aspire.dto.APIResponseDTO;
import in.softserv.aspire.dto.PolicyDTO;
import in.softserv.aspire.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/policy"})
public class PolicyController {
    private final Logger logger = LoggerFactory.getLogger(PolicyController.class);
    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponseDTO> createPolicy(@RequestBody PolicyDTO dto) {
        this.logger.info("In Policy Controller -> Create Policy " + dto.getMembershipNo());
        APIResponseDTO newDTO = this.service.createPolicy(dto);

        logger.info("controller {}", newDTO);

        return new ResponseEntity<>(newDTO, HttpStatus.valueOf(newDTO.getStatusCode() == 0 ? 200 : newDTO.getStatusCode()));
        //return new ResponseEntity<>(newDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponseDTO> updatePolicy(@RequestBody PolicyDTO dto) {
        this.logger.info("In Policy Controller -> Update Policy " + dto.getMembershipNo());
        APIResponseDTO newDTO = this.service.updatePolicy(dto);
        //newDTO.setStatusCode(200);
        logger.info("controller {}", newDTO);

        return new ResponseEntity<>(newDTO, HttpStatus.valueOf(newDTO.getStatusCode() == 0 ? 200 : newDTO.getStatusCode()));
        //return new ResponseEntity<>(newDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<APIResponseDTO> cancelPolicy(@RequestBody PolicyDTO dto) {
        this.logger.info("In Policy Controller -> Delete Policy " + dto.getMembershipNo());
        APIResponseDTO newDTO = this.service.cancelPolicy(dto);
        //newDTO.setStatusCode(200);
        logger.info("controller {}", newDTO);

        return new ResponseEntity<>(newDTO, HttpStatus.valueOf(newDTO.getStatusCode() == 0 ? 200 : newDTO.getStatusCode()));
        //return new ResponseEntity<>(newDTO, HttpStatus.OK);
    }
}