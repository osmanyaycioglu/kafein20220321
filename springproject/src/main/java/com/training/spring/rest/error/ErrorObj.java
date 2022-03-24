package com.training.spring.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         message;
    private int            errorCode;


    public static void main2(final String[] args) {
        ErrorObj addSubErrorLoc = ErrorObj.newInstance()
                                          .setMessage("validation error")
                                          .setErrorCode(100)
                                          .addSubError(newInstance().setMessage("name patladı")
                                                                    .setErrorCode(1002))
                                          .addSubError(newInstance().setMessage("surnmame patladı")
                                                                    .setErrorCode(1003));

        ErrorObjImmuBuild buildLoc = ErrorObjImmuBuild.getBuilder()
                                                      .setMessage("validation error")
                                                      .setErrorCode(100)
                                                      .addSubError(ErrorObjImmuBuild.getBuilder()
                                                                                    .setMessage("name patladı")
                                                                                    .setErrorCode(1002))
                                                      .addSubError(ErrorObjImmuBuild.getBuilder()
                                                                                    .setMessage("surnmame patladı")
                                                                                    .setErrorCode(1003))
                                                      .build();
    }

    public static ErrorObj newInstance() {
        return new ErrorObj();
    }

    public ErrorObj addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObj setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public ErrorObj setErrorCode(final int errorCodeParam) {
        this.errorCode = errorCodeParam;
        return this;
    }

}
