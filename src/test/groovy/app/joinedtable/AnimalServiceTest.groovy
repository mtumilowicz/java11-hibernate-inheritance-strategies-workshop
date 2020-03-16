package app.joinedtable

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class AnimalServiceTest extends Specification {

    @Autowired
    AnimalService animalService

    def setup() {
        savePets()
        saveWilds()
    }

    def cleanup() {
        animalService.deleteAll()
    }

    def savePets() {
        def pet = new Pet()
        pet.name = 'test pet'
        animalService.save(pet)
    }

    def saveWilds() {
        def wild = new Wild()
        wild.endangered = true

        animalService.save(wild)
    }

    def 'findAllPets'() {
        expect:
        animalService.findAllPets().name == ['test pet']
    }

    def 'findAllWilds'() {
        expect:
        animalService.findAllWilds().endangered == [true]
    }

    def 'findAll'() {
        expect:
        animalService.findAll().size() == 2
    }
}
