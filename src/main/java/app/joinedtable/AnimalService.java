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

    public Animal create(Animal animal) {
		return animalRepository.save(animal);
	}

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    public List<Wild> getWilds() {
        return wildRepository.findAll();
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public void deleteAll() {
        animalRepository.deleteAll();
    }
}