package in.softserv.aspire.helper;

import in.softserv.aspire.dto.PolicyDTO;

import java.util.Map;

public interface Helper {
    String getCustomerAPIURLWithData(String url);

    Map<String, String> getQParamsMapForCustomerAPI(PolicyDTO dto);
}