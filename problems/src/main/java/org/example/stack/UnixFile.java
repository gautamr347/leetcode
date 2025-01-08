package org.example.stack;

import java.util.*;

public class UnixFile {

    //In Unix-style file system context, a single period '.' signifies the current directory,
    // a double period ".." denotes moving up one directory level, and multiple slashes such as
    // "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered
    // by the previous rules (like "...") as valid names for files or directories.

    public static String simplifyPath(String path) {
        Deque<String> str = new LinkedList<>();
        String[] splitted = path.split("/");
        for (String split : splitted) {
            if (split.isBlank() || split.equals(".")) {
                continue;
            }
            if (split.equals("..") && !str.isEmpty()) {
                str.removeLast();
                continue;
            } else if (split.equals("..")) {
                continue;
            }
            str.add(split);
        }
        StringBuilder result = new StringBuilder();
        if (!str.isEmpty()) {
            while (!str.isEmpty()) {
                result.append("/").append(str.removeFirst());
            }
            return result.toString();
        }

        return "/";
    }

    public static void main(String[] args) {
        System.out.println(UnixFile.simplifyPath("/home/user/Documents/../Pictures"));
    }
}
