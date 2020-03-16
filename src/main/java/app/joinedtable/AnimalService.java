package app.joinedtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AnimalService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    WildRepository wildRepository;

    @Autowired
    AnimalRepository animalRepository;

    Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    List<Wild> findAllWilds() {
        return wildRepository.findAll();
    }

    List<Animal> findAll() {
        return animalRepository.findAll();
    }

    void deleteAll() {
        animalRepository.deleteAll();
    }
}