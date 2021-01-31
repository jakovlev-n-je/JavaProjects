package com.vgu.cs.course2.group11.calculation;

import com.vgu.cs.course2.group11.exceptions.CalculationException;

import java.util.LinkedList;
import java.util.List;

public class Sequences {

    public static int getInsufficientNumber(int numberIndex) throws CalculationException {
        if (numberIndex <= 0) {
            throw new CalculationException("Invalid index: " + numberIndex);
        }
        int currentIndex = 1;
        int currentNumber = 1;
        while (currentIndex <= numberIndex) {
            if (summarize(getDivisors(currentNumber)) < currentNumber) {
                currentIndex++;
            }
            currentNumber++;
        }
        return currentNumber - 1;
    }

    private static List<Integer> getDivisors(int number) {
        List<Integer> divisors = new LinkedList<>();
        for (int i = number - 1; i > 0; i--) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    private static int summarize(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
