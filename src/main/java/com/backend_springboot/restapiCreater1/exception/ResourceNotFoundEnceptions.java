package com.backend_springboot.restapiCreater1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ResourceNotFoundEnceptions extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private  String resourceName;
    private String  fieldName;
    private Object fieldValue;

    public ResourceNotFoundEnceptions(String resourceName, String fieldName, Object fieldValue) {
        super(String.format(" %S not found with %S : '%S' ", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
