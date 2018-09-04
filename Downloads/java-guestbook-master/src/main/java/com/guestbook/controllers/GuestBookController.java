package com.guestbook.controllers;

import com.google.gson.Gson;
import com.guestbook.models.CommentRequest;
import com.guestbook.models.GuestBookResponse;
import com.guestbook.models.SaveResponse;
import com.guestbook.services.GuestBookService;
import spark.Request;
import spark.Response;

public class GuestBookController {

    private Gson gson;
    private GuestBookService service;

    public GuestBookController(Gson gson, GuestBookService service) {
        this.gson = gson;
        this.service = service;
    }

    public Object get(Request request, Response response) {
        return gson.toJson(new GuestBookResponse(service.get()));
    }

    public Object getAll(Request request, Response response) {
        return null;
    }

    public Object save(Request request, Response response) {
        CommentRequest commentRequest = gson.fromJson(request.body(), CommentRequest.class);
        Integer id = service.save(commentRequest);
        return gson.toJson(new GuestBookResponse(new SaveResponse(id)));
    }

    public Object delete(Request request, Response response) {
        return null;
    }
}
