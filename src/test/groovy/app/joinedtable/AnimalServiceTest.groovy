package app.joinedtable

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class AnimalServiceTest extends Specification {

    @Autowired
    AnimalService animalService

    def setup() {
        createPets()
        createWilds()
    }

    def cleanup() {
        animalService.deleteAll()
    }

    def createPets() {
        def pet = new Pet()
        pet.name = 'test pet'
        animalService.create(pet)
    }

    def createWilds() {
        def wild = new Wild()
        wild.endangered = true

        animalService.create(wild)
    }

    def "GetPets"() {
        expect:
        animalService.getPets().name == ['test pet']
    }

    def "GetWilds"() {
        expect:
        animalService.getWilds().endangered == [true]
    }

    def "GetAll"() {
        expect:
        animalService.getAll().size() == 2
    }
}
