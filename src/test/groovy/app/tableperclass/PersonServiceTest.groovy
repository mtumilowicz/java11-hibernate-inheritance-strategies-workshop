package app.tableperclass


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class PersonServiceTest extends Specification {

    @Autowired
    PersonService personService

    def setup() {
        saveEmployers()
        saveEmployees()
    }

    def saveEmployers() {
        def employer = new Employer()
        employer.budget = 1000
        personService.save(employer)
    }

    def saveEmployees() {
        def employee = new Employee()
        employee.salary = 100
        personService.save(employee)
    }

    def cleanup() {
        personService.deleteAll()
    }

    def 'findAllPersons'() {
        expect:
        personService.findAllPersons().size() == 2
    }

    def 'findAllEmployees'() {
        expect:
        personService.findAllEmployees().salary == [100]
    }

    def 'findAllEmployers'() {
        expect:
        personService.findAllEmployers().budget == [1000]
    }
}
