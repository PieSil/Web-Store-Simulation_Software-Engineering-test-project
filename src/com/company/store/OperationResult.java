package com.company.store;

public class OperationResult {

    public OperationResult(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public void SetMessage(String message) {
        this.message = message;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public String getMessage() {
        return message;
    }


    private final boolean succeeded;
    private String message = "";
}
