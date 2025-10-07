package stark.coderaider.titan.treasure.core.config;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import stark.dataworks.boot.ExceptionLogger;
import stark.dataworks.boot.web.ServiceResponse;

import jakarta.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler({OSSException.class})
    public ServiceResponse<?> handleOssException(OSSException e)
    {
        String errorMessage = "Caught an OSSException, which means your request made it to OSS, but was rejected with an error response for some reason." +
            "Error Message: " + e.getErrorMessage() + ". " +
            "Error Code: " + e.getErrorCode() + ". " +
            "Request ID: " + e.getRequestId() + ". " +
            "Host ID: " + e.getHostId() + ". ";
        log.error(errorMessage);
        return ServiceResponse.buildErrorResponse(-100, errorMessage);
    }

    @ExceptionHandler({ClientException.class})
    public ServiceResponse<?> handleClientException(ClientException e)
    {
        String errorMessage = "Caught an ClientException, which means the client encountered "
            + "a serious internal problem while trying to communicate with OSS, "
            + "such as not being able to access the network."
            + "Error Message: " + e.getMessage();

        log.error(errorMessage);
        return ServiceResponse.buildErrorResponse(-100, errorMessage);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class, IllegalArgumentException.class})
    public ServiceResponse<?> handleValidationException(Exception e)
    {
        ExceptionLogger.logExceptionInfo(e);
        return ServiceResponse.buildErrorResponse(-100, e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ServiceResponse<?> handleException(Exception e)
    {
        ExceptionLogger.logExceptionInfo(e);
        return ServiceResponse.buildErrorResponse(-200, e.getMessage());
    }
}
