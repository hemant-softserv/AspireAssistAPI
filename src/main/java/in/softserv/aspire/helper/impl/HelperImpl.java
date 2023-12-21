package in.softserv.aspire.helper.impl;

import in.softserv.aspire.dto.PolicyDTO;
import in.softserv.aspire.helper.Helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelperImpl implements Helper {

    @Value("${user.api.assist.host}")
    private String host;


    @Value("${user.api.assist.customerQueryParam}")
    private String customerAPIQueryParam;


    public String getCustomerAPIURLWithData(String customerAPIURL) {
        return this.host + customerAPIURL + "?" + this.customerAPIQueryParam;
    }

    public Map<String, String> getQParamsMapForCustomerAPI(PolicyDTO dto) {
        Map<String, String> params = new HashMap<>();
        params.put("vehicleMake", dto.getVehicleMake());
        params.put("retailerName", dto.getRetailerName());
        params.put("planName", dto.getPlanName());
        params.put("userName", dto.getUserName());
        params.put("state", dto.getState());
        params.put("tempPassword", dto.getTempPassword());
        params.put("phone", dto.getPhone());
        params.put("vehicleModel", dto.getVehicleModel());
        params.put("lastName", dto.getVehicleMake());
        params.put("confirmCancellation", dto.getConfirmCancellation());
        params.put("membershipNo", dto.getMembershipNo());
        params.put("firstName", dto.getFirstName());
        params.put("year", dto.getYear());
        params.put("address", dto.getAddress());
        params.put("rego", dto.getRego());
        params.put("dealerName", dto.getDealerName());
        params.put("createdBy", dto.getCreatedBy());
        params.put("startDate", dto.getStartDate());
        params.put("postalCode", dto.getPostalCode());
        params.put("term", dto.getTerm());
        params.put("email", dto.getEmail());
        params.put("city", dto.getCity());
        params.put("apiKey", dto.getApiKey());
        return params;
    }
}