package com.fiap.store_flow.dto;

public class FieldMessage {
    private String fieldname;
    private String message;


    public FieldMessage(String fieldname, String message) {
        this.fieldname = fieldname;
        this.message = message;
    }

    public String getFieldname() {
        return fieldname;
    }

    public String getMessage() {
        return message;
    }
}
