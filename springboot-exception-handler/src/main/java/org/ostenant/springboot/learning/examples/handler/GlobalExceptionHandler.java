package org.ostenant.springboot.learning.examples.handler;

import org.ostenant.springboot.learning.examples.exception.ErrorInfo;
import org.ostenant.springboot.learning.examples.exception.IllegalPropException;
import org.ostenant.springboot.learning.examples.exception.NullOrEmptyException;
import org.ostenant.springboot.learning.examples.exception.SessionNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SessionNotFoundException.class)
    @ResponseBody
    public ErrorInfo<String> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(exception.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData(exception.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }

    @ExceptionHandler(value = NullOrEmptyException.class)
    @ResponseBody
    public ErrorInfo<String> nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException exception) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(exception.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData(exception.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }


    @ExceptionHandler(value = IllegalPropException.class)
    @ResponseBody
    public ErrorInfo<String> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropException exception) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(exception.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData(exception.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(exception.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData(exception.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }

}
