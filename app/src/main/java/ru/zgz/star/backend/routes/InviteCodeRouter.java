package ru.zgz.star.backend.routes;

import com.google.gson.Gson;

public class InviteCodeRouter {
    public static final String BASE_URL = "/inviteCode";

    public static String getInviteCode(String inviteCode) {
        return new Gson().toJson("inviteCode");
    }

    public static String invalidateInviteCode(String inviteCode) {
        return new Gson().toJson("OK");
    }
}
