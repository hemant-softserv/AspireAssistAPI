package in.softserv.aspire.thread;

import in.softserv.aspire.controller.PolicyController;
import in.softserv.aspire.dto.PolicyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class WorkerThread implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(PolicyController.class);
    private final String message;
    private final String membershipNo;

    private final String apiKey;

    public WorkerThread(String s, String membershipNo, String apiKey) {
        this.message = s;
        this.membershipNo = membershipNo;
        this.apiKey = apiKey;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        processmessage(membershipNo);
        System.out.println(Thread.currentThread().getName() + " (End)");
    }

    private void processmessage(String membershipNo) {
        PolicyDTO dto = PolicyDTO.builder()
                .vehicleMake("ALFA ROMEO")
                .retailerName("INTEGRITY CAR CARE")
                .planName("ICC-5S2")
                .userName("123456789")
                .state("QLD")
                .tempPassword("JONAS123")
                .phone("123456789")
                .vehicleModel("147")
                .lastName("JONAS")
                .confirmCancellation("No")
                .membershipNo(membershipNo)
                .firstName("SMITH1")
                .year("01/01/2022")
                .address("TRISTREET")
                .rego("FED4710")
                .dealerName("A1 Dealer")
                .createdBy("Aspire")
                .startDate("14/12/2023")
                .postalCode("4306")
                .term("2 Year")
                .email("VIDYASAGAR@SOFTSERV.IN")
                .city("MUIRLEA")
                .apiKey(apiKey)
                .build();
        String url = "http://localhost" + ":" + "8091" + "/policy";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PolicyDTO> httpEntity = new HttpEntity<>(dto, headers);
        try {
            logger.info(url);
            String result = restTemplate.postForObject(url, httpEntity, String.class);
            logger.info("Test result {}", result);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}