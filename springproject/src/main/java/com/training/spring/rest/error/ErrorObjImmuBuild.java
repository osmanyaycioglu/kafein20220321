package com.training.spring.rest.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ErrorObjImmuBuild {

    private final List<ErrorObjImmuBuild> subErrors;
    private final String                  message;
    private final int                     errorCode;

    private ErrorObjImmuBuild(final List<ErrorObjImmuBuild> subErrorsParam,
                              final String messageParam,
                              final int errorCodeParam) {
        super();
        this.subErrors = Collections.unmodifiableList(subErrorsParam);
        this.message = messageParam;
        this.errorCode = errorCodeParam;
    }


    //    public List<ErrorObjImmuBuild> getSubErrors() {
    //        return this.subErrors;
    //    }

    public Iterator<ErrorObjImmuBuild> iterator() {
        return this.subErrors.iterator();
    }

    public String getMessage() {
        return this.message;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public static ErrorObjImmuBuilder getBuilder() {
        return new ErrorObjImmuBuilder();
    }

    public static class ErrorObjImmuBuilder {

        private List<ErrorObjImmuBuild> subErrors;
        private String                  message;
        private int                     errorCode;

        private ErrorObjImmuBuilder() {
        }

        public ErrorObjImmuBuild build() {
            return new ErrorObjImmuBuild(this.subErrors,
                                         this.message,
                                         this.errorCode);
        }

        public ErrorObjImmuBuilder addSubError(final ErrorObjImmuBuilder errorObjParam) {
            if (this.subErrors == null) {
                this.subErrors = new ArrayList<>();
            }
            this.subErrors.add(new ErrorObjImmuBuild(errorObjParam.getSubErrors(),
                                                     errorObjParam.getMessage(),
                                                     errorObjParam.getErrorCode()));
            return this;
        }

        public List<ErrorObjImmuBuild> getSubErrors() {
            return this.subErrors;
        }

        public ErrorObjImmuBuilder setSubErrors(final List<ErrorObjImmuBuild> subErrorsParam) {
            this.subErrors = subErrorsParam;
            return this;
        }

        public String getMessage() {
            return this.message;
        }

        public ErrorObjImmuBuilder setMessage(final String messageParam) {
            this.message = messageParam;
            return this;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public ErrorObjImmuBuilder setErrorCode(final int errorCodeParam) {
            this.errorCode = errorCodeParam;
            return this;
        }

    }


}
