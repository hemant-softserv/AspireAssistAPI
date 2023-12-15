package in.softserv.aspire.helper;

import in.softserv.aspire.dto.PolicyDTO;

import java.util.Map;

public interface Helper {
    String getCreateCustomerAPIURLWithData();

    Map<String, String> getQParamsMapForCustomerCreateAPI(PolicyDTO dto);
}