package app.tableperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployerRepository employerRepository;

    Person save(Person person) {
        return personRepository.save(person);
    }

    List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    List<Employer> findAllEmployers() {
        return employerRepository.findAll();
    }

    void deleteAll() {
        personRepository.deleteAll();
    }
}