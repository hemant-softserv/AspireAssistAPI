package in.softserv.aspire.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PolicyDTO {

    @JsonProperty("VehicleMake")
    private String vehicleMake;
    @JsonProperty("RetailerName")
    private String retailerName;
    @JsonProperty("PlanName")
    private String planName;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("State")
    private String state;
    @JsonProperty("TempPassword")
    private String tempPassword;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("VehicleModel")
    private String vehicleModel;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("ConfirmCancellation")
    private String confirmCancellation;
    @JsonProperty("MembershipNo")
    private String membershipNo;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Rego")
    private String rego;
    @JsonProperty("DealerName")
    private String dealerName;
    @JsonProperty("CreatedBy")
    private String createdBy;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("Term")
    private String term;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("City")
    private String city;
    @JsonProperty("APIKey")
    private String apiKey;
    @JsonProperty("CustomerID")
    private int customerID;
    private String isForRenewal;
    @JsonProperty("CustomerAccess")
    private int customerAccess;
    private String isRenewed;
    @JsonProperty("StatusMessage")
    private String statusMessage;
    @JsonProperty("StatusCode")
    private int statusCode;

}