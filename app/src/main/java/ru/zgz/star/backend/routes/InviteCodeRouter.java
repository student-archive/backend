package ru.zgz.star.backend.routes;

import com.google.gson.Gson;

public class InviteCodeRouter {
    public static final String BASE_URL = "/inviteCode";

    public String postInviteCode() {
        return new Gson().toJson("OK");
    }
}
