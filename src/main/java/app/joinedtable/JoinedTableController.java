package app.joinedtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("joined-table")
public class JoinedTableController {

    @Autowired
    PetRepository petRepository;

    @Autowired
    WildRepository wildRepository;

    @Autowired
	AnimalRepository animalRepository;

    @PostMapping("pets")
    public Object createPet(@RequestBody Pet pet) {
		return animalRepository.save(pet);
	}

    @PostMapping("wilds")
    public Object createWild(@RequestBody Wild wild) {
        return animalRepository.save(wild);
    }

    @GetMapping("pets")
    public Object getPets() {
        return petRepository.findAll();
    }

    @GetMapping("wilds")
    public Object getWilds() {
        return wildRepository.findAll();
    }

    @GetMapping("animals")
    public Object get() {
        return animalRepository.findAll();
    }
}