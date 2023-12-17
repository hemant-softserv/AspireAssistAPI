package in.softserv.aspire.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class APIResponseDTO {

    private int customerID;

    private String memberShipNo;

    private String statusMessage;

    private int statusCode;

}