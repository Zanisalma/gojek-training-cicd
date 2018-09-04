package com.guestbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guestbook.controllers.GuestBookController;
import com.guestbook.repositories.GuestBookRepository;
import com.guestbook.services.GuestBookService;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.get;

public class GuestBookMainService {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().serializeNulls().create();
        GuestBookRepository guestBookRepository = new GuestBookRepository();
        GuestBookService guestBookService = new GuestBookService(guestBookRepository);
        GuestBookController guestBookController = new GuestBookController(gson, guestBookService);

        port(getHerokuAssignedPort());
        post("/internal/post/comment", guestBookController::save);
        get("/internal/get", guestBookController::get);
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

}
