package com.vgu.cs.course2.group11;

import com.vgu.cs.course2.group11.bloomFilter.BloomFilter;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> baseContent = Arrays.asList("Красный", "Оранжевый", "Желтый", "Зеленый",
                "Голубой", "Синий", "Фиолетовый");
        BloomFilter requestFilter = new BloomFilter(baseContent);
        Set<String> cache = new HashSet<>(baseContent);
        System.out.println("""
                Список комманд:
                <request> - сделать запрос;
                getCache - получить список кэшированных значений;
                exit - завершить работу;

                Внимание! При вводе запроса учитывается регистр символов!""");
        Scanner scanner = new Scanner(System.in);
        String request;
        while (true) {
            System.out.print("\nВведите команду или новый запрос: ");
            request = scanner.nextLine().trim();
            if (request.equals("exit")) {
                System.out.println("Спасибо за использование нашей программы!");
                return;
            }
            if (request.equals("getCache")) {
                printCache(cache);
                continue;
            }
            if (cache.contains(request)) {
                System.out.printf("Запрос \"%s\" не требует кэширования\n", request);
            } else {
                if (requestFilter.mightContain(request)) {
                    cache.add(request);
                    System.out.printf("Запрос \"%s\" был успешно закэширован\n", request);
                } else {
                    requestFilter.put(request);
                    System.out.printf("Запрос \"%s\" не требует кэширования, так как является одноразовым\n", request);
                }
            }
        }
    }

    private static void printCache(Set<String> cache) {
        System.out.println("\nКэшированные элементы:");
        for (String item : cache) {
            System.out.printf("%s \n", item);
        }
    }
}
