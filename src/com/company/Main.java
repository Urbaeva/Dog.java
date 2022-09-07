package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        for (int i = 1; i <= 50; i++) {
            double weight = random.nextDouble(0,10);
            BigDecimal bd = new BigDecimal(weight).setScale(2, RoundingMode.HALF_DOWN);
            animalLinkedList.add(new Cat("Cat" + i, random.nextInt(1,10), bd.doubleValue()));
            weight = random.nextDouble(0,10);
            bd = new BigDecimal(weight).setScale(2, RoundingMode.HALF_DOWN);
            animalLinkedList.add(new Cat("Dog" + i, random.nextInt(1,10), bd.doubleValue()));
        }

        int countD = 0, counterDog = 4;
        int countC = 0, counterCat = 5;
    }
}
