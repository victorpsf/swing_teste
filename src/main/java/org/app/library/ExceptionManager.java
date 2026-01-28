package org.app.library;

import java.util.ArrayList;
import java.util.List;

public class ExceptionManager {
    public static String read(Exception e) {
        List<String> parts = new ArrayList<>();

        parts.add(String.format("message: %s", e.getMessage()));

        for (StackTraceElement stack: e.getStackTrace()) {
            parts.add(String.format("stack trace :: %s", stack.toString()));
        }

        return String.join("\n", parts);
    } 
}
