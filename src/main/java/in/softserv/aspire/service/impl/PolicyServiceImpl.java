package in.softserv.aspire.service.impl;

import in.softserv.aspire.dto.APIResponseDTO;
import in.softserv.aspire.dto.PolicyDTO;
import in.softserv.aspire.helper.Helper;
import in.softserv.aspire.service.PolicyService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PolicyServiceImpl implements PolicyService {
    private final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

    @Value("${user.api.assist.createCustomer}")
    private String createCustomerAPIURL;
    @Value("${user.api.assist.updateCustomer}")
    private String updateCustomerAPIURL;
    @Value("${user.api.assist.cancelCustomer}")
    private String cancelCustomerAPIURL;
    final RestTemplate restTemplate;
    final Helper helper;



    public PolicyServiceImpl( RestTemplate restTemplate, Helper helper) {
        this.restTemplate = restTemplate;
        this.helper = helper;
    }

    public APIResponseDTO createPolicy(PolicyDTO dto) {

        String url = helper.getCustomerAPIURLWithData(createCustomerAPIURL);
        logger.info("url {}",url);

        Map<String, String> params = helper.getQParamsMapForCustomerAPI(dto);
        logger.info("params {}",params);

        APIResponseDTO rDTO=this.sendPolicyDataToAssist(url,params);

        logger.info("create customer output {}", rDTO);
        return rDTO;

    }

    @Override
    public APIResponseDTO updatePolicy(PolicyDTO dto) {

        String url = helper.getCustomerAPIURLWithData(updateCustomerAPIURL);
        logger.info("url {}",url);

        Map<String, String> params = helper.getQParamsMapForCustomerAPI(dto);
        logger.info("params {}",params);

        APIResponseDTO rDTO=this.sendPolicyDataToAssist(url,params);
        logger.info("update customer output {}", rDTO);
        return rDTO;

    }

    @Override
    public APIResponseDTO cancelPolicy(PolicyDTO dto) {

        String url = helper.getCustomerAPIURLWithData(cancelCustomerAPIURL);
        logger.info("url {}",url);

        Map<String, String> params = helper.getQParamsMapForCustomerAPI(dto);
        logger.info("params {}",params);

        APIResponseDTO rDTO=this.sendPolicyDataToAssist(url,params);
        logger.info("delete customer output {}", rDTO);
        return rDTO;

    }

    private APIResponseDTO sendPolicyDataToAssist(String url, Map<String, String> params) {

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

        return newResDto;
    }
}