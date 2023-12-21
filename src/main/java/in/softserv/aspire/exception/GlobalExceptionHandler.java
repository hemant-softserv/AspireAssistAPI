package in.softserv.aspire.exception;

import in.softserv.aspire.dto.APIResponseDTO;

import java.net.SocketTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({SocketTimeoutException.class})
    public ResponseEntity<APIResponseDTO> socketTimeOutExceptionHandler(SocketTimeoutException ex) {
        logger.info("Socket time out exception occurred!!!");
        APIResponseDTO aDto = APIResponseDTO.builder()
                .statusMessage(ex.getMessage())
                .statusCode(HttpStatus.REQUEST_TIMEOUT.value())
                .build();
        logger.info("error response {}",aDto);
        return new ResponseEntity<>(aDto, HttpStatus.OK);
    }
}