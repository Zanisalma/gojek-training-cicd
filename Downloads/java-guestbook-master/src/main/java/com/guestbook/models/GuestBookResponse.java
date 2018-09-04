package com.guestbook.models;

import java.util.ArrayList;
import java.util.List;

public class GuestBookResponse {

    public Object data;
    public Boolean isSuccees;
    public List<Error> errors;

    public GuestBookResponse(Object data) {
        this.data = data;
        this.isSuccees = true;
        this.errors = new ArrayList<>();
    }

    public GuestBookResponse(Object data, Boolean isSuccees, List<Error> errors) {
        this.data = data;
        this.isSuccees = isSuccees;
        this.errors = errors;
    }

    public class Error {
        public String message;

        public Error(String message) {
            this.message = message;
        }
    }
}
