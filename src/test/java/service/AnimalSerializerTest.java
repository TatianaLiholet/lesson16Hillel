package service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import model.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalSerializerTest {
    private final AnimalSerializer animalJsonSerializer = new AnimalSerializer(new JsonMapper());
    List<Animal> petShelter = new ArrayList<>();

    private final Animal input = new Animal("sharik", "Tomas");


    @Test
    public void serializeTest(){
        animalJsonSerializer.serialize(petShelter);
    }



    }

