package com.vgu.cs.course2.group11;

import com.vgu.cs.course2.group11.calculation.Sequences;
import com.vgu.cs.course2.group11.exceptions.CalculationException;
import com.vgu.cs.course2.group11.exceptions.HashtableException;
import com.vgu.cs.course2.group11.table.Hashtable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws HashtableException, CalculationException {
        Hashtable hashtable = new Hashtable();
        Scanner scanner = new Scanner(System.in);
        int numberIndex;
        while (true) {
            System.out.print("Введите порядковый номер вашего недостаточного числа: ");
            numberIndex = scanner.nextInt();
            if (numberIndex == -1) {
                return;
            } else {
                if (!hashtable.containsKey(numberIndex)) {
                    int value = Sequences.getInsufficientNumber(numberIndex);
                    hashtable.put(numberIndex, value);

                }
                System.out.printf("Число с порядковым номером %d равно: %d\n\n", numberIndex,
                        hashtable.getValue(numberIndex));
            }
        }
    }
}
