package com.vgu.cs.course2.group11.command;

import com.vgu.cs.course2.group11.exceptions.SplayTreeException;
import com.vgu.cs.course2.group11.tree.SplayTree;

public class CommandCaller {

    private final SplayTree splayTree;

    public CommandCaller() {
        this.splayTree = new SplayTree();
    }

    public void call(Command command) throws SplayTreeException {
        int key;
        switch (command.getIndex()) {
            case 0:
                System.out.println("Спасибо за использование нашей программы!");
                System.exit(1);
            case 1:
                System.out.print(getHelp());
                break;
            case 2:
                splayTree.clear();
                System.out.println("Дерево было успешно очищенно");
                break;
            case 3:
                key = Integer.parseInt(String.valueOf(command.getParameters()[0]));
                System.out.printf("Значение элемента с ключом \"%d\": %s\n", key, splayTree.getValue(key));
                break;
            case 4:
                System.out.printf("Дерево содержит %d элементов\n", splayTree.getSize());
                break;
            case 5:
                key = Integer.parseInt(String.valueOf(command.getParameters()[0]));
                String value = String.valueOf(command.getParameters()[1]);
                splayTree.insert(key, value);
                System.out.printf("Элемент с ключом \"%d\" и значением \"%s\" был успешно добавлен в дерево\n",
                        key, value);
                break;
            case 6:
                System.out.printf("Дерево не содержит элементов: %b\n", splayTree.isEmpty());
                break;
            case 7: {
                System.out.print("Все ключи дерева:");
                splayTree.print();
                System.out.println();
                break;
            }
            case 8: {
                key = Integer.parseInt(String.valueOf(command.getParameters()[0]));
                splayTree.remove(key);
                System.out.printf("Элемент с ключом \"%d\" был успешно удален из дерева\n", key);
                break;
            }
        }
    }

    private String getHelp() {
        return "\nclear - очистить дерево;\n" +
                "getValue <ключ> - получить значение элемента дерева по ключу;\n" +
                "getSize - получить размер дерева;\n" +
                "insert <ключ> <значение> - вставить в дерево новый элемент;\n" +
                "isEmpty - узнать наличие элементов в дереве;\n" +
                "print - вывести все ключи дерева;\n" +
                "remove <ключ> - удалить значение элемента дерева по ключу;\n";
    }
}
