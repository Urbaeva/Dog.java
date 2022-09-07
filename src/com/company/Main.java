package com.company;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            double weight = random.nextDouble(0,10);
            BigDecimal bd = new BigDecimal(weight).setScale(2, RoundingMode.HALF_DOWN);
            animalLinkedList.add(new Cat("Cat"+(i+1), random.nextInt(1,9), bd.doubleValue()) );
            weight = random.nextDouble(0,10);
            bd = new BigDecimal(weight).setScale(2, RoundingMode.HALF_DOWN);
            animalLinkedList.add(new Dog("Dog"+(i+1), random.nextInt(1,9), bd.doubleValue()));
        }

        int counterCat = 0, cat = 5;
        int counterDog = 0, dog = 4;
        for (int i = 0; i < animalLinkedList.size(); i++) {
            if (animalLinkedList.get(i) instanceof Cat) {
                counterCat++;
            }
            if (counterCat == cat) {
                animalLinkedList.remove(i);
                cat += 5;
            }
            if (animalLinkedList.get(i) instanceof Dog) {
                counterDog++;
                if (counterDog == dog) {
                    double weight = random.nextDouble(0,2);
                    BigDecimal bd = new BigDecimal(weight).setScale(2, RoundingMode.HALF_DOWN);
                    animalLinkedList.add(i, new Mouse("Mouse", random.nextInt(1,9), bd.doubleValue()));
                    dog += 4;
                }
            }
        }

        LinkedList<Animal> catLinkedList = new LinkedList<>();
        for (int i = 0; i < animalLinkedList.size(); i++) {
            if (animalLinkedList.get(i) instanceof Mouse && animalLinkedList.get(i-1) instanceof Cat) {
                catLinkedList.add(animalLinkedList.get(i-1) );
                animalLinkedList.remove(i-1);
            }
        }
        System.out.println(animalLinkedList);


        ArrayList<Animal> animalArrayList = new ArrayList<>(animalLinkedList);
        int sumOfAgeOfAnimals = 0;
        for (int i = 0; i < animalArrayList.size(); i++) {
            sumOfAgeOfAnimals += animalArrayList.get(i).getAge();
        }
        System.out.println("Sum of age of animals = " + sumOfAgeOfAnimals);

        LinkedList<Animal> newLinkedList = new LinkedList<>();
        for (int i = 0; i < animalLinkedList.size(); i++)
            if (animalArrayList.get(i) instanceof Cat)
                newLinkedList.add(animalLinkedList.get(i));

        for (int i = 0; i < animalLinkedList.size(); i++)
            if (animalArrayList.get(i) instanceof Dog)
                newLinkedList.add(animalLinkedList.get(i));

        for (int i = 0; i < animalLinkedList.size(); i++)
            if (animalArrayList.get(i) instanceof Mouse)
                newLinkedList.add(animalLinkedList.get(i));

        System.out.println("\n------------New LinkedList--------------");
        System.out.println(newLinkedList);
    }
}