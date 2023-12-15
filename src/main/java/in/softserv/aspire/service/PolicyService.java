package in.softserv.aspire.service;

import in.softserv.aspire.dto.APIResponseDTO;
import in.softserv.aspire.dto.PolicyDTO;

public interface PolicyService {
    APIResponseDTO createPolicy(PolicyDTO dto);
}