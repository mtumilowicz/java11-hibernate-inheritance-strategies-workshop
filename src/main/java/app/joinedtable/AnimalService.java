package app.joinedtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    WildRepository wildRepository;

    @Autowired
	AnimalRepository animalRepository;

    public Animal save(Animal animal) {
		return animalRepository.save(animal);
	}

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public List<Wild> findAllWilds() {
        return wildRepository.findAll();
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public void deleteAll() {
        animalRepository.deleteAll();
    }
}