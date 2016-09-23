package com.github.bluemonster122.util;

import javax.annotation.Nullable;

public class MessageLoading {

    public static String getMessage(int stage, boolean starting, @Nullable String name) {
        String message = ModInfo.MOD_NAME;
        if (name != null) {
            message += "-" + name;
        }
        message += starting ? " has started " : " has finished ";

        switch (stage) {
            case 0:
                message += "Pre-Initialising";
                break;
            case 1:
                message += "Initialising";
                break;
            case 2:
                message += "Post-Initialising";
                break;
            default:
                message = "ERROR";
                break;
        }
        return message;
    }

    public static String getMessage(int stage, boolean starting) {
        return getMessage(stage, starting, null);
    }
}
