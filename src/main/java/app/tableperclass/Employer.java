package app.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
class Employer extends Person {

    private int budget;
}
