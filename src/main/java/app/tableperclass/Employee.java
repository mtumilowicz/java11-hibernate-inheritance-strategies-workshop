package app.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
class Employee extends Person {

    private int salary;
}
