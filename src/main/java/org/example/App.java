package org.example;


import com.fasterxml.jackson.databind.json.JsonMapper;
import model.Animal;
import service.AnimalSerializer;

import java.util.*;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalSerializer animalSerializer = new AnimalSerializer(new JsonMapper());
        List<Animal> animals = AnimalSerializer.deserialize();
        System.out.println(animals);
        System.out.println("Do you want to add a pet? Yes / No");
        String answer = scanner.next();


        if (answer.equals("Yes")) {
            System.out.println("Enter the name of the animal and owner name");
            animals.add(new Animal(scanner.next(), scanner.next()));
            animalSerializer.serialize(animals);
            System.out.println(animals);
        } else System.out.println("You don't add any pet");


        System.out.println("Do you want to see all pets? Yes / No");
        answer = scanner.next();


        if (answer.equals("Yes")) {
            System.out.println(AnimalSerializer.deserialize());
        }

        System.out.println("Do you want to took any pets? Yes / No");
        answer = scanner.next();
        if (answer.equals("Yes")) {
            System.out.println("Enter the name of the pet you want to take");
            String answerNameOfPet = scanner.next();
            System.out.println(animals);

            for (Animal animal : animals) {
                System.out.println(animal);
                System.out.println(animal.getName());
                System.out.println(answerNameOfPet);
                if (animal.getName().equals(answerNameOfPet)) {
                    animals.remove(animal);
                }
            }
            animalSerializer.serialize(animals);

        }
        AnimalSerializer.deserialize();

        scanner.close();
    }


}
