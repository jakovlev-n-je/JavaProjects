package com.vgu.cs.course2.group11;

import com.vgu.cs.course2.group11.exceptions.SplayTreeException;
import com.vgu.cs.course2.group11.command.CommandCaller;
import com.vgu.cs.course2.group11.command.CommandParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SplayTreeException {
        CommandCaller commandCaller = new CommandCaller();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Внимание! При вызове команды, не имеющией параметров, ненужные параметры не учитываются автоматически!\n" +
                "\"help\" - вызов справки;\n" +
                "\"end\" - завершение работы;");
        while (true) {
            System.out.print("\nВведите команду и ее параметры: ");
            commandCaller.call(CommandParser.parse(scanner.nextLine().trim()));
        }
    }
}
