package in.softserv.aspire.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class APIResponseDTO {

    @JsonProperty("CustomerID")
    private int customerID;
    @JsonProperty("StatusMessage")
    private String statusMessage;
    @JsonProperty("StatusCode")
    private int statusCode;

}