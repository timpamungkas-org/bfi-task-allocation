package id.co.bfi.bfitaskallocation.api.exception.handler;

import java.sql.SQLException;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import id.co.bfi.bfitaskallocation.api.response.base.JsonBaseError;
import id.co.bfi.bfitaskallocation.api.response.base.JsonBaseResponse;
import id.co.bfi.bfitaskallocation.constant.ApiGenericExceptionHandlerConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * Generic exception handler for <code>RestController</code>.
 * 
 * @author timpamungkas
 *
 */
@RestControllerAdvice
@Slf4j
public class ApiGenericExceptionHandler {

  /**
   * Handle validation exception thrown by <code>@Valid</code> failures.
   * 
   * @param e the exception
   * @return generic-format JSON error message
   */
  @ExceptionHandler({ org.springframework.web.bind.MethodArgumentNotValidException.class })
  public ResponseEntity<JsonBaseResponse<String>> handleMethodArgumentNotValidException(
      org.springframework.web.bind.MethodArgumentNotValidException e) {
    var startTime = System.currentTimeMillis();
    var message = e.getFieldErrors().stream()
        .map(f -> f.getField() + " (value : " + f.getRejectedValue() + ") " + f.getDefaultMessage())
        .collect(Collectors.joining(", "));

    var genericError = JsonBaseError.builder().code(ApiGenericExceptionHandlerConstants.CODE_BAD_REQUEST)
        .message(ApiGenericExceptionHandlerConstants.MESSAGE_BAD_INPUT_FROM_CLIENT).reason(message).build();
    var body = new JsonBaseResponse<String>(startTime, genericError);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(body);
  }

  /**
   * Handle validation exception thrown by request body invalid.
   * 
   * @param e the exception
   * @return generic-format JSON error message
   */
  @ExceptionHandler({ HttpMessageNotReadableException.class })
  public ResponseEntity<JsonBaseResponse<String>> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException e) {
    var startTime = System.currentTimeMillis();

    var genericError = JsonBaseError.builder().code(ApiGenericExceptionHandlerConstants.CODE_UNREADABLE_REQUEST_BODY)
        .message(ApiGenericExceptionHandlerConstants.MESSAGE_CANNOT_READ_REQUEST)
        .reason(ApiGenericExceptionHandlerConstants.REASON_CANNOT_READ_REQUEST_BODY).build();
    var body = new JsonBaseResponse<String>(startTime, genericError);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(body);
  }

  /**
   * Handle <code>SQLException</code>, hiding sql stack trace.
   * 
   * @param e the exception
   * @return generic-format JSON error message
   */
  @ExceptionHandler({ SQLException.class })
  public ResponseEntity<JsonBaseResponse<String>> handleSQLException(SQLException e) {
    var startTime = System.currentTimeMillis();
    log.error("{}", e.getMessage());

    var genericError = JsonBaseError.builder().code(ApiGenericExceptionHandlerConstants.CODE_SQL_EXCEPTION)
        .message(ApiGenericExceptionHandlerConstants.MESSAGE_SQL_EXCEPTION).reason(e.getMessage()).build();
    var body = new JsonBaseResponse<String>(startTime, genericError);

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(body);
  }

}
