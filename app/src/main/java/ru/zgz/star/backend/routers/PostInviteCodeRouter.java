package ru.zgz.star.backend.routers;

import com.google.gson.Gson;

public class PostInviteCodeRouter {
    public static final String BASE_URL = "/inviteCode";

    public String postInviteCode() {
        return new Gson().toJson("OK");
    }
}