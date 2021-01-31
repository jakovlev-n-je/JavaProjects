package com.vgu.cs.course2.group11.command;

import java.util.LinkedList;
import java.util.List;

public class CommandParser {

    public static Command parse(String line) {
        return determineCommand(getNotEmptyStrings(line.split(" ")));
    }

    private static Command determineCommand(String[] command) {
        switch (command[0].toLowerCase()) {
            case "end":
                return new Command(0);
            case "help":
                return new Command(1);
            case "clear":
                return new Command(2);
            case "getvalue":
                return new Command(3, new Object[]{command[1]});
            case "getsize":
                return new Command(4);
            case "insert":
                return new Command(5, new Object[]{command[1], command[2]});
            case "isempty":
                return new Command(6);
            case "print":
                return new Command(7);
            case "remove":
                new Command(8, new Object[]{command[1]});
            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }

    private static String[] getNotEmptyStrings(String[] array) {
        List<String> list = new LinkedList<>();
        for (String line : array) {
            if (!line.trim().equals("")) {
                list.add(line);
            }
        }
        return list.toArray(new String[0]);
    }
}