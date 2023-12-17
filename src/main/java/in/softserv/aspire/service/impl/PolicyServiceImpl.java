package in.softserv.aspire.service.impl;

import in.softserv.aspire.dto.APIResponseDTO;
import in.softserv.aspire.dto.PolicyDTO;
import in.softserv.aspire.helper.Helper;
import in.softserv.aspire.service.PolicyService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PolicyServiceImpl implements PolicyService {
    private final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);
    final RestTemplate restTemplate;
    final Helper helper;

    public PolicyServiceImpl(RestTemplate restTemplate, Helper helper) {
        this.restTemplate = restTemplate;
        this.helper = helper;
    }

    public APIResponseDTO createPolicy(PolicyDTO dto) {

        return this.sendPolicyDataToAssist(dto);
    }

    private APIResponseDTO sendPolicyDataToAssist(PolicyDTO dto) {

        String url = helper.getCreateCustomerAPIURLWithData();
        Map<String, String> params = helper.getQParamsMapForCustomerCreateAPI(dto);
        PolicyDTO result = restTemplate.getForObject(url, PolicyDTO.class, params);
        APIResponseDTO newResDto;
        if (result != null) {
            synchronized (PolicyDTO.class) {
                newResDto = APIResponseDTO.builder()
                        .statusMessage(result.getStatusMessage())
                        .statusCode(result.getStatusCode())
                        .customerID(result.getCustomerID())
                        .memberShipNo(result.getMembershipNo())
                        .build();
            }

        } else {
            newResDto = APIResponseDTO.builder().build();
        }

        // logger.info("create customer output {}", newResDto);
        return newResDto;
    }
}
