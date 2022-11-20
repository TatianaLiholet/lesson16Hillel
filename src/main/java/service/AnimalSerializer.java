package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Animal;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalSerializer {
    private static ObjectMapper mapper;
    private static String path = "src/main/resources/animalOut";

    public AnimalSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public static void serialize(List<Animal> petShelter) {
        try {
            mapper.writeValue(new File(path + ".json"), petShelter);
        } catch (IOException e) {
            System.out.println("cannot create file !");
            e.printStackTrace();
        }
    }

    public static List<Animal> deserialize() {
        List<Animal> animals = new ArrayList<>();
        try {
            File animalList = new File("src/main/resources/animalOut.json");
            animals = mapper.readValue(animalList, List.class);
            // System.out.println(animals);
        } catch (IOException e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }

        return animals;
    }
}




