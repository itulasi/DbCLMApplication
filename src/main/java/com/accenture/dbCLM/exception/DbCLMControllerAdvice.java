package com.accenture.dbCLM.exception;

import com.accenture.dbCLM.DbClmApplication;
import com.accenture.dbCLM.model.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DbCLMControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(DbClmApplication.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                                                  final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        logger.error("Exception occurred in the application :: "+exception.getMessage());
        logger.error("Requested UI :: "+request.getRequestURI());
        return error;
    }

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleInvalidDataAccess(final Exception exception,
                                                           final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        logger.error("Exception occurred in the application :: "+exception.getMessage());
        logger.error("Requested UI :: "+request.getRequestURI());
        return error;
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public @ResponseBody ExceptionResponse handleMissingPathVariable(final Exception exception,
                                                           final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        logger.error("Exception occurred in the application :: "+exception.getMessage());
        logger.error("Requested UI :: "+request.getRequestURI());
        return error;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    public @ResponseBody ExceptionResponse handleNoSuchElement(final Exception exception,
                                                                     final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        logger.error("Exception occurred in the application :: "+exception.getMessage());
        logger.error("Requested UI :: "+request.getRequestURI());
        return error;
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleException(final Exception exception,
                                                           final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());

        return error;
    }

}
