package com.exception;

import com.utility.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class APIExceptionHandler {


    private final String OTHER_EXCEPTION = "OTHER_EXCEPTION";
    private final String ESB_SERVICE_EXCEPTION = "ESB_SERVICE_EXCEPTION";
    private final String EntityNotFoundException = "EntityNotFoundException";
    private final String DatabaseException = "DatabaseException";

    @ExceptionHandler(value = APIRequestException.class)
    public ResponseEntity<Object> handleExeption(APIRequestException apiReqException){
        HttpStatus exception = HttpStatus.EXPECTATION_FAILED;
        APIException apiException = new APIException();
        if(apiReqException != null &&
                apiReqException.getCause() instanceof EntityNotFoundException) {
            apiException.setErrorCode(
                    ErrorCode.valueOf(EntityNotFoundException).getErrorCode());
            apiException.setErrorMessage(EntityNotFoundException);
            exception = HttpStatus.NOT_FOUND;
        }else if(apiReqException != null &&
                apiReqException.getCause() instanceof DatabaseException) {
            apiException.setErrorCode(
                    ErrorCode.valueOf(DatabaseException).getErrorCode());
            apiException.setErrorMessage(DatabaseException);
            exception = HttpStatus.INTERNAL_SERVER_ERROR;
        } else if(apiReqException != null &&
                apiReqException.getCause() instanceof ServiceException){
            apiException.setErrorCode(
                    ErrorCode.valueOf(ESB_SERVICE_EXCEPTION).getErrorCode());
            apiException.setErrorMessage(ESB_SERVICE_EXCEPTION);
            exception = HttpStatus.INTERNAL_SERVER_ERROR;
        }else{
            apiException.setErrorCode(
                    ErrorCode.valueOf(OTHER_EXCEPTION).getErrorCode());
            apiException.setErrorMessage(OTHER_EXCEPTION);
        }
        apiException.setHttpStatus(exception);
        apiException.setTimestamp(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

       return new ResponseEntity<>(apiException, exception);
    }
}
